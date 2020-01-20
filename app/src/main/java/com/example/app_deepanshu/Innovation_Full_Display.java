package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.app_deepanshu.Innovation_List_Show.districtd;
import static com.example.app_deepanshu.Innovation_List_Show.named;
import static com.example.app_deepanshu.Innovation_List_Show.prob_sold;
import static com.example.app_deepanshu.Innovation_List_Show.prob_titd;
import static com.example.app_deepanshu.Innovation_List_Show.schoold;
import static com.example.app_deepanshu.Innovation_List_Show.sol_descd;
import static com.example.app_deepanshu.Innovation_List_Show.sol_titd;
import static com.example.app_deepanshu.Innovation_List_Show.stated;
import static com.example.app_deepanshu.Innovation_List_Show.techd;

public class Innovation_Full_Display extends AppCompatActivity {

    private TextView name1,school1,district1,state1,tech1,prob_tit1,prob_desc1,sol_tit1,sol_desc1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovation__full__display);

        Intent intent=getIntent();
        String name12= intent.getStringExtra(named);
        String schol12= intent.getStringExtra(schoold);
        String district12= intent.getStringExtra(districtd);
        String state12= intent.getStringExtra(stated);
        String pro12= intent.getStringExtra(prob_titd);
        String p_desc12= intent.getStringExtra(prob_sold);
        String sol12= intent.getStringExtra(sol_titd);
        String s_desc12= intent.getStringExtra(sol_descd);
        String tech12= intent.getStringExtra(techd);


        name1=findViewById(R.id.name);
        school1=findViewById(R.id.school);
        district1=findViewById(R.id.district);
        state1=findViewById(R.id.state);
        tech1=findViewById(R.id.tech);
        prob_tit1=findViewById(R.id.pro_title);
        prob_desc1=findViewById(R.id.pro_desc);
        sol_tit1=findViewById(R.id.sol_title);
        sol_desc1=findViewById(R.id.sol_desc);


        name1.setText(name12);
        school1.setText(schol12);
        district1.setText(district12);
        state1.setText(state12);
        tech1.setText(tech12);
        prob_tit1.setText(pro12);
        prob_desc1.setText(p_desc12);
        sol_tit1.setText(sol12);
        sol_desc1.setText(s_desc12);

    }
}
