package edu.ucu.cite.deaftouchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignQuizGame extends AppCompatActivity {

    EditText editText_name;
    Button button_save;
    SharedPreferences sharedPreferences;

    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_NAME = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_quiz_game);


        editText_name = findViewById(R.id.editext_name);
        button_save = findViewById(R.id.button_save);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);


        String name = sharedPreferences.getString(KEY_NAME, null);

        if (name != null){
            Intent intent = new Intent(SignQuizGame.this, MiniGamesPage.class);
            startActivity(intent);
            finish();
        }

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText_name.getText().toString().isEmpty()){

                    Toast.makeText(SignQuizGame.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();

                }else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_NAME, editText_name.getText().toString());
                    editor.apply();

                    Intent intent = new Intent(SignQuizGame.this, MiniGamesPage.class);
                    startActivity(intent);
                    finish();

                }


            }
        });

    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setMessage("Are You Sure Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

                        String name = sharedPreferences.getString(KEY_NAME, null);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.commit();
                        finishAffinity();

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void backbuttonimage(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        finish();

    }
}