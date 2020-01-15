package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Report_By_Teacher extends AppCompatActivity {

    EditText naam,aadhar,classe,subjects,teach_nam,validity,total_clss,attend_class
            ,exam_name,marks,suggestion;
    private long lastClickTime = 0;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report__by__teacher);

        naam=(EditText)findViewById(R.id.naams);
        aadhar=(EditText)findViewById(R.id.aadhar);
        classe=(EditText)findViewById(R.id.classs);
        subjects=(EditText)findViewById(R.id.subject);
        teach_nam=(EditText)findViewById(R.id.tch_naam);
        validity=(EditText)findViewById(R.id.val);
        total_clss=(EditText)findViewById(R.id.total);
        attend_class=(EditText)findViewById(R.id.attend);
        exam_name=(EditText)findViewById(R.id.exm);
        marks=(EditText)findViewById(R.id.marks);
        suggestion=(EditText)findViewById(R.id.sugg);


        btnsave=(Button)findViewById(R.id.button_submit);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if (SystemClock.elapsedRealtime() - lastClickTime < 1000){
                    return;
                }

                lastClickTime = SystemClock.elapsedRealtime();
                Call<DefaultResponse> call= RetrofitClient.getInstance()
                        .getApi()
                        .addReport(naam.getText().toString()
                                ,Integer.parseInt(aadhar.getText().toString())
                                ,classe.getText().toString()
                                ,subjects.getText().toString()
                                ,teach_nam.getText().toString()
                                ,validity.getText().toString()
                                ,Integer.parseInt(total_clss.getText().toString())
                                ,Integer.parseInt(attend_class.getText().toString())
                                ,exam_name.getText().toString()
                                ,Integer.parseInt(marks.getText().toString())
                                ,15
                                ,true
                                ,"Moderate"
                                ,"Good Player"
                                ,"Take part "
                                ,"Lack of moral education"
                                ,"Lack Of concentration"
                                ,suggestion.getText().toString()
                                );
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse dr = response.body();
                        Toast.makeText(Report_By_Teacher.this,response.message(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                        Toast.makeText(Report_By_Teacher.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });










    }
}
