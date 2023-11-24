package edu.ucu.cite.deaftouchapp.LearnCategoryPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import edu.ucu.cite.deaftouchapp.R;

public class Category_Item_Data extends AppCompatActivity {

    TextView name;
    ImageView image, sounds;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__item__data);

        name = findViewById(R.id.griddata);
        image = findViewById(R.id.imageViewCategory);
        sounds = findViewById(R.id.sounds);



        Intent intent = getIntent();

        int mp3 = getIntent().getIntExtra("sound", 0);
        final MediaPlayer mp = MediaPlayer.create(this, mp3);

        sounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));


    }

    public void backbuttonimage(View view) {
        finish();
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}