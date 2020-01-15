package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class School_Activity_For_Students extends AppCompatActivity {

    private EditText notices,venues,teacher,student;
    private Button btnsave;
    private long lastClickTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school___for__students);

        notices=(EditText) findViewById(R.id.Notice);
        venues=(EditText) findViewById(R.id.Venue);
        teacher=(EditText) findViewById(R.id.Teacher);
        student=(EditText) findViewById(R.id.Student);
        btnsave=(Button) findViewById(R.id.save);

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
                        .addActivity(notices.getText().toString()
                                ,venues.getText().toString()
                                ,teacher.getText().toString()
                                ,student.getText().toString()
                                ,"1");
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse dr = response.body();
                        Toast.makeText(School_Activity_For_Students.this,response.message(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                        Toast.makeText(School_Activity_For_Students.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
