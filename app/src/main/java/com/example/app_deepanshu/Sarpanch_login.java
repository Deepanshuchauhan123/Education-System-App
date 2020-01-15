package com.example.app_deepanshu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class Sarpanch_login extends AppCompatActivity {

    private Button sarpanchreg;
    private Button sarpanchsubmit;
    private long lastClickTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarpanch_login);

        sarpanchreg = (Button) findViewById(R.id.patient_reg);
        sarpanchreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - lastClickTime < 1000){
                    return;
                }

                lastClickTime = SystemClock.elapsedRealtime();
                Intent i1 = new Intent(Sarpanch_login.this, Sarpanch_reg.class);
                startActivity(i1);
            }
        });
        sarpanchsubmit = (Button) findViewById(R.id.button_login);
        sarpanchsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (SystemClock.elapsedRealtime() - lastClickTime < 1000){
                    return;
                }

                lastClickTime = SystemClock.elapsedRealtime();
                Intent i = new Intent(Sarpanch_login.this,Sarpanch_main.class);
                startActivity(i);
            }
        });
    }
}
