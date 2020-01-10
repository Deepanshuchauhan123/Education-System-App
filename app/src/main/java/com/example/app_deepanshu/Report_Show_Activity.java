package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.app_deepanshu.api.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Report_Show_Activity extends AppCompatActivity {

    ArrayList<ReportModel> reportModels=new ArrayList<>();
    private ReportsAdapter reportsAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report__show_);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview_report);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getReportResponse();
    }

    private void getReportResponse() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<ReportModel>> call = api.getReport();

        call.enqueue(new Callback<List<ReportModel>>() {

            @Override
            public void onResponse(Call<List<ReportModel>> call, Response<List<ReportModel>> response) {

                reportModels=new ArrayList<>(response.body());
                reportsAdapter=new ReportsAdapter(Report_Show_Activity.this,reportModels);
                recyclerView.setAdapter(reportsAdapter);
            }

            @Override
            public void onFailure(Call<List<ReportModel>> call, Throwable t) {

            }
        });
    }
}
