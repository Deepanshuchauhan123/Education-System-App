package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.app_deepanshu.Schemes_Activity.aboutd;
import static com.example.app_deepanshu.Schemes_Activity.bend;
import static com.example.app_deepanshu.Schemes_Activity.catd;
import static com.example.app_deepanshu.Schemes_Activity.descd;
import static com.example.app_deepanshu.Schemes_Activity.genderd;
import static com.example.app_deepanshu.Schemes_Activity.leveld;
import static com.example.app_deepanshu.Schemes_Activity.linkd;
import static com.example.app_deepanshu.Schemes_Activity.orgd;
import static com.example.app_deepanshu.Schemes_Activity.titlesd;
import static com.example.app_deepanshu.Schemes_Activity.typed;

public class Scheme_Full_Display extends AppCompatActivity {

    private TextView type1,cat,gender,level,
    ben,org,title,about,desc,link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme__full__display);

        Intent intent=getIntent();
        String type12= intent.getStringExtra(typed);
        String cat12= intent.getStringExtra(catd);
        String gender12= intent.getStringExtra(genderd);
        String level12= intent.getStringExtra(leveld);
        String ben12= intent.getStringExtra(bend);
        String org12= intent.getStringExtra(orgd);
        String title12= intent.getStringExtra(titlesd);
        String about12= intent.getStringExtra(aboutd);
        String desc12= intent.getStringExtra(descd);
        String link12= intent.getStringExtra(linkd);



        type1=findViewById(R.id.type);
        cat=findViewById(R.id.cat);
        gender=findViewById(R.id.gender);
        level=findViewById(R.id.level);
        ben=findViewById(R.id.ben);
        org=findViewById(R.id.org);
        title=findViewById(R.id.title);
        about=findViewById(R.id.scholar);
        desc=findViewById(R.id.desc);
        link=findViewById(R.id.link);

        type1.setText(type12);
        cat.setText(cat12);
        gender.setText(gender12);
        level.setText(level12);
        ben.setText(ben12);
        org.setText(org12);
        title.setText(title12);
        about.setText(about12);
        desc.setText(desc12);
        link.setText(link12);





    }
}
