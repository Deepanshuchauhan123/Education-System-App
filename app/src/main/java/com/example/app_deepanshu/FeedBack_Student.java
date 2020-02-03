package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.app_deepanshu.api.RetrofitClient;
import com.example.app_deepanshu.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedBack_Student extends AppCompatActivity {

    RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,
    radioGroup5,radioGroup6,radioGroup7,radioGroup8,radioGroup9
            ,radioGroup10;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4,
            radioButton5,radioButton6,radioButton7,radioButton8,radioButton9
            ,radioButton10;
    Boolean b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back__student);

        radioGroup1=findViewById(R.id.radio_grp1);
        radioGroup2=findViewById(R.id.radio_grp2);
        radioGroup3=findViewById(R.id.radio_grp3);
        radioGroup4=findViewById(R.id.radio_grp4);
        radioGroup5=findViewById(R.id.radio_grp5);
        radioGroup6=findViewById(R.id.radio_grp6);
        radioGroup7=findViewById(R.id.radio_grp7);
        radioGroup8=findViewById(R.id.radio_grp8);
        radioGroup9=findViewById(R.id.radio_grp9);
        radioGroup10=findViewById(R.id.radio_grp10);
        btnsave=(Button)findViewById(R.id.submit);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                // get selected radio button from radioGroup
                int selectedId1 = radioGroup1.getCheckedRadioButtonId();
                radioButton1 = (RadioButton) findViewById(selectedId1);

                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                radioButton2 = (RadioButton) findViewById(selectedId2);

                int selectedId3 = radioGroup3.getCheckedRadioButtonId();
                radioButton3 = (RadioButton) findViewById(selectedId3);

                int selectedId4 = radioGroup4.getCheckedRadioButtonId();
                radioButton4 = (RadioButton) findViewById(selectedId4);

                int selectedId5 = radioGroup5.getCheckedRadioButtonId();
                radioButton5 = (RadioButton) findViewById(selectedId5);

                int selectedId6 = radioGroup6.getCheckedRadioButtonId();
                radioButton6 = (RadioButton) findViewById(selectedId6);

                int selectedId7 = radioGroup7.getCheckedRadioButtonId();
                radioButton7 = (RadioButton) findViewById(selectedId7);

                int selectedId8 = radioGroup8.getCheckedRadioButtonId();
                radioButton8 = (RadioButton) findViewById(selectedId8);

                int selectedId9 = radioGroup9.getCheckedRadioButtonId();
                radioButton9 = (RadioButton) findViewById(selectedId9);

                int selectedId10 = radioGroup10.getCheckedRadioButtonId();
                radioButton10 = (RadioButton) findViewById(selectedId10);

               // Toast.makeText(FeedBack_Student.this,radioButton1.getText(),Toast.LENGTH_LONG).show();

                if(radioButton1.getText().equals("Yes") ||radioButton1.getText().equals("हाँ") )
                {
                    b1=true;
                }else
                {
                    b1=false;
                }
                if(radioButton2.getText().equals("Yes")||radioButton2.getText().equals("हाँ"))
                {
                    b2=true;
                }else
                {
                    b2=false;
                }
                if(radioButton3.getText().equals("Yes")||radioButton3.getText().equals("हाँ"))
                {
                    b3=true;
                }else
                {
                    b3=false;
                }
                if(radioButton4.getText().equals("Yes")||radioButton4.getText().equals("हाँ"))
                {
                    b4=true;
                }else
                {
                    b4=false;
                }
                if(radioButton5.getText().equals("Yes")||radioButton5.getText().equals("हाँ"))
                {
                    b5=true;
                }else
                {
                    b5=false;
                }
                if(radioButton6.getText().equals("Yes")||radioButton6.getText().equals("हाँ"))
                {
                    b6=true;
                }else
                {
                    b6=false;
                }
                if(radioButton7.getText().equals("Yes")||radioButton7.getText().equals("हाँ"))
                {
                    b7=true;
                }else
                {
                    b7=false;
                }
                if(radioButton8.getText().equals("Yes")||radioButton8.getText().equals("हाँ"))
                {
                    b8=true;
                }else
                {
                    b8=false;
                }
                if(radioButton9.getText().equals("Yes")||radioButton9.getText().equals("हाँ"))
                {
                    b9=true;
                }else
                {
                    b9=false;
                }
                if(radioButton10.getText().equals("Yes")||radioButton10.getText().equals("हाँ"))
                {
                    b10=true;
                }else
                {
                    b10=false;
                }

                //b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,

                Call<DefaultResponse> call= RetrofitClient.getInstance()
                        .getApi()
                        .addFeedback(true,true,true,true,true,true,true,
                                true,true,true,"3","2","2","3");

                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        DefaultResponse dr = response.body();
                     Toast.makeText(FeedBack_Student.this,response.message(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {

                        Toast.makeText(FeedBack_Student.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

}
