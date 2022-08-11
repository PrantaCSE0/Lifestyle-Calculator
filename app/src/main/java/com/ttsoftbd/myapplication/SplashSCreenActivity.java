package com.ttsoftbd.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashSCreenActivity extends AppCompatActivity {

    ImageView GoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        GoMain = findViewById(R.id.GoMain);

        GoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashSCreenActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}