package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FeedBack_Student extends AppCompatActivity {

    RadioGroup radioGroup1,radioGroup2,radioGroup3,radioGroup4,
    radioGroup5,radioGroup6,radioGroup7,radioGroup8,radioGroup9
            ,radioGroup10;
    RadioButton radioButton;
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
            public void onClick(View v) {

            }
        });


    }
    public void CheckedButton(View v){

    }
}
