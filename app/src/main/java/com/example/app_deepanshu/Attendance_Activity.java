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
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class Attendance_Activity extends AppCompatActivity {

    ArrayList <AttendanceModel> attendanceModels=new ArrayList<>();
    private AttendanceAdapter attendanceAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_);

        recyclerView=(RecyclerView)findViewById(R.id.att_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getAttResponse();
    }

    private void getAttResponse() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<AttendanceModel>> call = api.getstudents();

        call.enqueue(new Callback<List<AttendanceModel>>() {
            @Override
            public void onResponse(Call<List<AttendanceModel>> call, Response<List<AttendanceModel>> response) {

                attendanceModels= new ArrayList<>(response.body());
                attendanceAdapter=new AttendanceAdapter(Attendance_Activity.this,attendanceModels);
                recyclerView.setAdapter(attendanceAdapter);
                Toast.makeText(Attendance_Activity.this,response.message(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<AttendanceModel>> call, Throwable t) {

                Toast.makeText(Attendance_Activity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
