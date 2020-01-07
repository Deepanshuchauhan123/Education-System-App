package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Teacher_self_Detail extends AppCompatActivity
{
    EditText subjects,batch;
    Spinner classes,stream;
    int c,s;
    String citem,sitem;
    Button btnsave;
    teacher subject;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_self__detail);

        //level = (Spinner) findViewById(R.id.level);
        classes  = (Spinner) findViewById(R.id.classes);
        stream  = (Spinner) findViewById(R.id.stream);

//        level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
//        {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//            {
//                 litem = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(), litem, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent)
//            {
//                // can leave this empty
//            }
//        });

        // Div Spinner implementing onItemSelectedListener
        classes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                citem = parent.getItemAtPosition(position).toString();
                c=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }

        });
        stream.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                sitem = parent.getItemAtPosition(position).toString();
                s=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // can leave this empty
            }

        });

        subjects=(EditText)findViewById(R.id.subject);
        batch=(EditText)findViewById(R.id.batch);
        final String Batch = batch.getText().toString().trim();
        btnsave=(Button)findViewById(R.id.btnsave);

        subject=new teacher();

      //  final FirebaseDatabase database = FirebaseDatabase.getInstance();
     //   final DatabaseReference reff = database.getReference("Teacher_portal").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<DefaultResponse> call= RetrofitClient.getInstance()
                                    .getApi()
                                    .addTeacherDetail(sitem,Batch,"1","1","1");
                            call.enqueue(new Callback<DefaultResponse>() {
                                @Override
                                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                                        DefaultResponse dr = response.body();
                                        Toast.makeText(Teacher_self_Detail.this,response.message(), Toast.LENGTH_LONG).show();
                                      }
                                @Override
                                public void onFailure(Call<DefaultResponse> call, Throwable t) {

                                    Toast.makeText(Teacher_self_Detail.this,t.getMessage(),Toast.LENGTH_LONG).show();
                                }
                            });
            }
        });
    }

}
