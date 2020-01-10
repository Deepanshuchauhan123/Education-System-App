package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class parents_grid extends AppCompatActivity {

    Button repot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_grid);


        repot = (Button) findViewById(R.id.report);
        repot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(parents_grid.this, Report_Show_Activity.class);
                startActivity(i);
            }
        });
    }
}
