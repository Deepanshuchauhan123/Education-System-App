package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.app_deepanshu.api.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class teacher_Self_Display extends AppCompatActivity {
private RecyclerView mRecyclerView;
ArrayList<Subject_Model_Teach> subject_model_teaches= new ArrayList<>();
private SubAdapter subAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__self__display);

        mRecyclerView= (RecyclerView)findViewById(R.id.recyclerview_subjects);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSchemeResponse();
    }
    private void getSchemeResponse()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<Subject_Model_Teach>> call = api.getSubject();

        call.enqueue(new Callback<List<Subject_Model_Teach>>() {
            @Override
            public void onResponse(Call<List<Subject_Model_Teach>> call, Response<List<Subject_Model_Teach>> response) {

                subject_model_teaches= new ArrayList<>(response.body());
                subAdapter =new SubAdapter(teacher_Self_Display.this,subject_model_teaches);
                mRecyclerView.setAdapter(subAdapter);
                Toast.makeText(teacher_Self_Display.this,response.message(),Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<List<Subject_Model_Teach>> call, Throwable t) {

                Toast.makeText(teacher_Self_Display.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
