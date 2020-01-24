package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_Student extends AppCompatActivity {
    private Spinner classes1,stream1;
    int s;
    String c;
    public  String citem;
    public  String sitem;
    private EditText batch;
    private EditText name;
    private EditText father;
    private EditText adhaar;
    private Button submit;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student);
        classes1  = (Spinner) findViewById(R.id.classes);
        stream1  = (Spinner) findViewById(R.id.stream);
        batch=(EditText) findViewById(R.id.student_batch);
        name=(EditText) findViewById(R.id.student_name);
        father=(EditText) findViewById(R.id.student_father);
        adhaar=(EditText) findViewById(R.id.student_adhaar);
        submit=(Button) findViewById(R.id.button_submit);
        back=(Button) findViewById(R.id.button_back);
        classes1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                citem = parent.getItemAtPosition(position).toString();
                if(citem.equals("V")){
                   c="8";
                }
                    else
                if(citem.equals("VI")){
                    c="9";
                }
                    else
                if(citem.equals("VII")){
                    c="10";
                }
                    else
                if(citem.equals("VIII")){
                    c="11";
                }
                    else
                if(citem.equals("IX")){
                    c="12";
                }
                    else
                if(citem.equals("X")){
                    c="13";
                }
                    else
                if(citem.equals("XI")){
                    c="14";
                }    else
                if(citem.equals("XII")){
                    c="15";
                }
                else
                {
                    Toast.makeText(Add_Student.this, "Enter Valid Class", Toast.LENGTH_SHORT).show();
                    return;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        stream1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {   sitem = parent.getItemAtPosition(position).toString();
                s=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Call<DefaultResponse> call= RetrofitClient.getInstance()
                        .getApi()
                        .addStudent(sitem
                                ,batch.getText().toString()
                                ,name.getText().toString()
                                ,father.getText().toString()
                                ,adhaar.getText().toString()
                                ,c
                        );
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse dr = response.body();
                        Toast.makeText(Add_Student.this,response.message(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                        Toast.makeText(Add_Student.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();return;
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.commit();
    }
}
