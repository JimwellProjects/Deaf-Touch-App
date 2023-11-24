package edu.ucu.cite.deaftouchapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

//        getSupportActionBar().hide();
    }

    public void getstarted(View view) {
        Intent i = new Intent(WelcomePage.this,MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        finish();
    }
}