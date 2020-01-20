package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

public class Innovation_List_Show extends AppCompatActivity implements InnovationAdapter.OnItemClickListener {

    public static final String named="reger";
    public static final String schoold="hj";
    public static final String districtd="jhgc";
    public static final String stated="gu";
    public static final String prob_titd="hjd";
    public static final String prob_sold="jbdfk";
    public static final String sol_titd="udsfk";
    public static final String sol_descd="udhf";
    public static final String techd="udf";

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
                innovationAdapter.setOnItemClickListener(Innovation_List_Show.this);
            }

            @Override
            public void onFailure(Call<List<InnovationModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void OnItemClick(int position) {

        Intent detailtaIntent=new Intent(this,Innovation_Full_Display.class);
        InnovationModel clickedItem= innovationModels.get(position);

        detailtaIntent.putExtra(named,clickedItem.getName());
        detailtaIntent.putExtra(schoold,clickedItem.getSchool());
        detailtaIntent.putExtra(districtd,clickedItem.getDistrict());
        detailtaIntent.putExtra(stated,clickedItem.getState());
        detailtaIntent.putExtra(prob_titd,clickedItem.getProbTitle());
        detailtaIntent.putExtra(prob_sold,clickedItem.getProbDesc());
        detailtaIntent.putExtra(sol_titd,clickedItem.getSolTitle());
        detailtaIntent.putExtra(sol_descd,clickedItem.getSolDesc());
        detailtaIntent.putExtra(techd,clickedItem.getTechnique());

        startActivity(detailtaIntent);
    }
}
