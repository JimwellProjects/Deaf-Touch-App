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

import edu.ucu.cite.deaftouchapp.FlashCardGame.FlashCardGameSelectCategories;
import edu.ucu.cite.deaftouchapp.GuessTheSignGame.GuessTheSignGameSelectCategories;
import edu.ucu.cite.deaftouchapp.GuessTheSignGame.GuessTheSignGame_1;

public class GuessSignGameWelcomePage extends AppCompatActivity {
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_sign_game_welcome_page);
        myDialog = new Dialog(this);
    }

    public void ShowPopUp(View view){
        ImageView txtclose, popupimage;

        myDialog.setContentView(R.layout.game_pop_up);

        popupimage = myDialog.findViewById(R.id.popupimage);
        popupimage.setImageResource(R.drawable.signguess);

        TextView popuptitle = myDialog.findViewById(R.id.popuptitle);
        popuptitle.setText("Guess The Sign Language");

        VideoView videoView = myDialog.findViewById(R.id.VideoViewTutorial);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.guessthesignvideo);
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

    public void GuessTheSignGame(View view) {
        Intent i = new Intent(GuessSignGameWelcomePage.this, GuessTheSignGameSelectCategories.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}