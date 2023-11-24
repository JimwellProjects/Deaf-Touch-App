package edu.ucu.cite.deaftouchapp.GuessTheSignGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.ucu.cite.deaftouchapp.FlashCardGame.FlashCardGameSelectCategories;
import edu.ucu.cite.deaftouchapp.MiniGamesPage;
import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.SharedPrefManager;

public class GuessTheSignGameResult extends AppCompatActivity {


    TextView textView_name, textView_score, tv_congratulations;
    String correctanswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_sign_game_result);


        textView_name = findViewById(R.id.tv_name);
        textView_score = findViewById(R.id.tv_score);
        tv_congratulations = findViewById(R.id.tv_congratulations);

        String username = SharedPrefManager.getInstance(this).getUsername();

        if (username != null){
            textView_name.setText("Hi," + " " + username + " "+ "Ready For The Next Categories "  );
        }
    }

    @Override
    public void onBackPressed() {
        new android.app.AlertDialog.Builder(this)
                .setMessage("Are You Sure Want To Quit This Game?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(getApplicationContext(), MiniGamesPage.class));
                        finish();
                        overridePendingTransition(R.anim.fadein,R.anim.fadeout);

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void backbuttonimage(View view) {

        startActivity(new Intent(getApplicationContext(), MiniGamesPage.class));
        finish();
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);

    }

    public void ExitGame(View view) {
        startActivity(new Intent(getApplicationContext(), MiniGamesPage.class));
        finish();
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    public void playagain(View view) {
        startActivity(new Intent(getApplicationContext(), GuessTheSignGameSelectCategories.class));
        finish();
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}