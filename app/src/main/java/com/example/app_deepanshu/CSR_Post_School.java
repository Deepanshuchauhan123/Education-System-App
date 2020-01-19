package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class CSR_Post_School extends AppCompatActivity {

    private Button btnsave;
    private EditText name1,desig1,title1,desc1,year1,month1,day1,place1;
    private String date1;
    private long lastClickTime =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csr__post__school);

        name1=(EditText)findViewById(R.id.school_name);
        desig1=(EditText)findViewById(R.id.desig);
        title1 = (EditText)findViewById(R.id.title);
        desc1 = (EditText)findViewById(R.id.descps);
        year1=(EditText)findViewById(R.id.year);
        month1=(EditText)findViewById(R.id.month);
        day1=(EditText)findViewById(R.id.day);
        place1 = (EditText)findViewById(R.id.place);
        btnsave=(Button)findViewById(R.id.submits);


        date1=year1.getText().toString()+"-"+month1.getText().toString()+"-"+day1.getText().toString();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Call<DefaultResponse> call= RetrofitClient.getInstance()
                        .getApi()
                        .addCSR(name1.getText().toString(),
                                desig1.getText().toString(),
                                title1.getText().toString(),
                                desc1.getText().toString(),
                                year1.getText().toString()+"-"+month1.getText().toString()+"-"+day1.getText().toString(),
                                place1.getText().toString()
                                );
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse dr = response.body();
                        Toast.makeText(CSR_Post_School.this,response.message(), Toast.LENGTH_LONG).show();

                        Intent i = new Intent(CSR_Post_School.this, CSR_Post_School.class);
                        startActivity(i);
                    }
                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                        Toast.makeText(CSR_Post_School.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
