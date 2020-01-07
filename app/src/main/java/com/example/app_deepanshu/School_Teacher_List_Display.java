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

public class School_Teacher_List_Display extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private PostAdapter postAdapter;
    ArrayList<Display_teach> display_teaches=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school__teacher__list__display);

        mRecyclerView=(RecyclerView) findViewById(R.id.postlist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api=retrofit.create(Api.class);
        Call<List<Display_teach>> call=api.getTeachers();

        call.enqueue(new Callback<List<Display_teach>>() {
            @Override
            public void onResponse(Call<List<Display_teach>> call, Response<List<Display_teach>> response) {

                display_teaches=new ArrayList<>(response.body());
                postAdapter =new PostAdapter(School_Teacher_List_Display.this,display_teaches);

                mRecyclerView.setAdapter(postAdapter);
               //  mRecyclerView.setAdapter(new PostAdapter(School_Teacher_List_Display.this,   ));

//                List<Display_teach> display =response.body();
//
//                String[] teacherName=new String[display.size()];
//                String[] teacheremail=new String[display.size()];
//                String[] teachermobile=new String[display.size()];
//                String[] teacheradd=new String[display.size()];
//                String[] teacherstate=new String[display.size()];
//
//                for(int i=0;i<display.size();i++){
//                    teacherName[i]= display.get(i).getName();
//                    teacheremail[i]= display.get(i).getEmail();
//                    teachermobile[i]= display.get(i).getMobile();
//                    teacheradd[i]= display.get(i).getAddress();
//                    teacherstate[i]= display.get(i).getState();
//
//
//                }
//
//                listView.setAdapter(
//                        new ArrayAdapter<String>(
//                                getApplicationContext(),
//                                android.R.layout.simple_list_item_1,
//                                teacherName
//                        )
//                );
//                listView.setAdapter(
//                        new ArrayAdapter<String>(
//                                getApplicationContext(),
//                                android.R.layout.simple_list_item_1,
//                                teacheremail
//                        )
//                );


//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent i=new Intent(School_Teacher_List_Display.this,Teacher_List_Activity.class);
//                        startActivity(i);
//                    }
//                });
            }

            @Override
            public void onFailure(Call<List<Display_teach>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

       // mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_teachers);
//        new firebaseDatabaseHelpers().readteachers(new firebaseDatabaseHelpers.DataStatus() {
//            @Override
//            public void DataIsLoaded(List<teachers> teachs, List<String> keys) {
//                new RecyclerView_teacher().setConfig(mRecyclerView,School_Teacher_List_Display.this,
//                        teachs,keys);
//            }
//
//            @Override
//            public void DataIsDeleted() {
//
//            }
//        });
    }
}