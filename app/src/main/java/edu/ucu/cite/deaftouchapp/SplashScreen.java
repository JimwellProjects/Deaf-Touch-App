package edu.ucu.cite.deaftouchapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import edu.ucu.cite.deaftouchapp.IntroScreen.IntroActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreen.this, IntroActivity.class));
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);

            }
        },1200);
    }
}