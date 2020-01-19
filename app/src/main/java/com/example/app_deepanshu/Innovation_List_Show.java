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

public class Innovation_List_Show extends AppCompatActivity {

    ArrayList<InnovationModel> innovationModels =new ArrayList<>();
    private InnovationAdapter innovationAdapter;

    private RecyclerView innov_recs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovation__list__show);

        innov_recs=(RecyclerView)findViewById(R.id.innov_rec);
        innov_recs.setLayoutManager(new LinearLayoutManager(this));
        getInnovationResponse();
    }

    private void getInnovationResponse() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<InnovationModel>> call = api.getInnovation();

        call.enqueue(new Callback<List<InnovationModel>>() {
            @Override
            public void onResponse(Call<List<InnovationModel>> call, Response<List<InnovationModel>> response) {

                innovationModels=new ArrayList<>(response.body());
                innovationAdapter=new InnovationAdapter(Innovation_List_Show.this,innovationModels);
                innov_recs.setAdapter(innovationAdapter);
            }

            @Override
            public void onFailure(Call<List<InnovationModel>> call, Throwable t) {

            }
        });
    }
}
