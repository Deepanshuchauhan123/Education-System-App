package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.app_deepanshu.api.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Student_Activities_Get extends AppCompatActivity {

    ArrayList <ActivitiesModel> activitiesModels=new ArrayList<>();
    private ActivitiesAdapter activitiesAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__activities__get);

        recyclerView=(RecyclerView)findViewById(R.id.activity_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getActivitiesResponse();


    }

    private void getActivitiesResponse() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<ActivitiesModel>> call = api.getActivities();

        call.enqueue(new Callback<List<ActivitiesModel>>() {
            @Override
            public void onResponse(Call<List<ActivitiesModel>> call, Response<List<ActivitiesModel>> response) {

                activitiesModels=new ArrayList<>(response.body());
                activitiesAdapter=new ActivitiesAdapter(Student_Activities_Get
                        .this,activitiesModels);
                recyclerView.setAdapter(activitiesAdapter);
            }

            @Override
            public void onFailure(Call<List<ActivitiesModel>> call, Throwable t) {

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