package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class student_grid extends AppCompatActivity {
    private Button secondgrid;
    private Button innovation;
    private Button feedback,scheme;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student_grid);

            secondgrid = (Button) findViewById(R.id.quiz);
            secondgrid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(student_grid.this, quiz_grid.class);
                    startActivity(i);
                }
            });
            innovation = (Button) findViewById(R.id.innovation);
            innovation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(student_grid.this, innovation_grid.class);
                    startActivity(i);
                }
            });
            feedback = (Button) findViewById(R.id.feedback);
            feedback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(student_grid.this, FeedBack_Student.class);
                    startActivity(i);
                }
            });
            scheme = (Button) findViewById(R.id.scheme);
            scheme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(student_grid.this, Schemes_Activity.class);
                    startActivity(i);
                }
            });
        }
}
