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
import retrofit2.converter.gson.GsonConverterFactory;

public class Schemes_Activity extends AppCompatActivity implements SchemesAdapter.OnItemClickListener {

    public static final String typed="reger";
    public static final String catd="hj";
    public static final String genderd="jhgc";
    public static final String leveld="gu";
    public static final String bend="hjd";
    public static final String orgd="jbdfk";
    public static final String titlesd="udsfk";
    public static final String aboutd="udhf";
    public static final String descd="udf";
    public static final String linkd="udfk";


    ArrayList<Schemes_Model> schemes_models=new ArrayList<>();
    private SchemesAdapter schemesAdapter;
    private RecyclerView scheme_recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes_);

        scheme_recyclerview=(RecyclerView)findViewById(R.id.scheme_recyclerview);

        scheme_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        getSchemeResponse();


    }

    private void getSchemeResponse() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);
        Call<List<Schemes_Model>> call = api.getSchemes();

        call.enqueue(new Callback<List<Schemes_Model>>() {
            @Override
            public void onResponse(Call<List<Schemes_Model>> call, Response<List<Schemes_Model>> response) {

                schemes_models= new ArrayList<>(response.body());
                schemesAdapter=new SchemesAdapter(Schemes_Activity.this,schemes_models);
                scheme_recyclerview.setAdapter(schemesAdapter);
                schemesAdapter.setOnItemClickListener(Schemes_Activity.this);
                Toast.makeText(Schemes_Activity.this,response.message(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<List<Schemes_Model>> call, Throwable t) {

                Toast.makeText(Schemes_Activity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onItemClick(int position) {
        Intent detailtaIntent=new Intent(this,Scheme_Full_Display.class);
        Schemes_Model clickedItem= schemes_models.get(position);

        detailtaIntent.putExtra(typed,clickedItem.getType());
        detailtaIntent.putExtra(catd,clickedItem.getCat());
        detailtaIntent.putExtra(genderd,clickedItem.getGender());
        detailtaIntent.putExtra(leveld,clickedItem.getLevel());
        detailtaIntent.putExtra(bend,clickedItem.getBeneficiary());
        detailtaIntent.putExtra(orgd,clickedItem.getOrg());
        detailtaIntent.putExtra(titlesd,clickedItem.getTitle());
        detailtaIntent.putExtra(aboutd,clickedItem.getAbout());
        detailtaIntent.putExtra(descd,clickedItem.getDesc());
        detailtaIntent.putExtra(linkd,clickedItem.getLink());

        startActivity(detailtaIntent);
    }
}
