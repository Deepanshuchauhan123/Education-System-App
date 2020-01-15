package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class innovation_grid extends AppCompatActivity {

    private Button new_ideas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_innovation_grid);

        new_ideas=(Button)findViewById(R.id.new_add);
        new_ideas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(innovation_grid.this, Innovation_Student_Activity.class);
                startActivity(in);
            }
        });




    }
}
