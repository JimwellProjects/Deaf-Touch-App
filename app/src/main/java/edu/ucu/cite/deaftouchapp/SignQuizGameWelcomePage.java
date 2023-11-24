package edu.ucu.cite.deaftouchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class SignQuizGameWelcomePage extends AppCompatActivity {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_quiz_game_welcome_page);
        myDialog = new Dialog(this);

    }
    public void ShowPopUp(View view){
        ImageView txtclose;

        myDialog.setContentView(R.layout.game_pop_up);

        ImageView popupimage = myDialog.findViewById(R.id.popupimage);
        popupimage.setImageResource(R.drawable.signquiz);

        TextView popuptitle = myDialog.findViewById(R.id.popuptitle);
        popuptitle.setText("Sign Language Quiz");

        VideoView videoView = myDialog.findViewById(R.id.VideoViewTutorial);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.signquizvideo);
        videoView.setVideoURI(uri);
        videoView.start();

        txtclose =(ImageView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();

    }

    public void SignLangaugeQuizGame(View view) {
        Intent i = new Intent(SignQuizGameWelcomePage.this, SignQuizGameSelectCategories.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }


}