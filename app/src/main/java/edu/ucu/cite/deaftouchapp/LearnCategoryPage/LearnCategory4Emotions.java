package edu.ucu.cite.deaftouchapp.LearnCategoryPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;

import edu.ucu.cite.deaftouchapp.AboutUsPage;
import edu.ucu.cite.deaftouchapp.LearnCategory;
import edu.ucu.cite.deaftouchapp.MainActivity;
import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.VideosPage;

public class LearnCategory4Emotions extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView gridView;
    String [] EmotionsLetters = {

                "Angry ","Bored ","Calm ","Cheeky ","Contented ",
                "Depressed ","Disgust ","Excited ","Frightened ","Happy ",
                "Nervous ","Relax ","Sad ","Shy ","Sleepy ",
                "Sneaky ","Sorry","Stressed ","Surprised ","Tense ","Upset "};



    int[] EmotionsImages = {
            R.drawable.emotiosn_angry,R.drawable.emotiosn_bored,R.drawable.emotiosn_calm,R.drawable.emotiosn_cheeky,R.drawable.emotiosn_contented,
            R.drawable.emotiosn_depressed,R.drawable.emotiosn_disgust,R.drawable.emotiosn_excited,R.drawable.emotiosn_frightened,R.drawable.emotiosn_happy,
            R.drawable.emotiosn_nervous,R.drawable.emotiosn_relax,R.drawable.emotiosn_sad,R.drawable.emotiosn_shy,R.drawable.emotiosn_sleepy,
            R.drawable.emotiosn_sneaky,R.drawable.emotiosn_sorry,R.drawable.emotiosn_stressed,R.drawable.emotiosn_surprised,R.drawable.emotiosn_tense,R.drawable.emotiosn_upset};


    int[] Emotionssound = {

            R.raw.emotions_angry,R.raw.emotions_bored,R.raw.emotions_calm,R.raw.emotions_cheeky,R.raw.emotions_contented,
            R.raw.emotions_depressed,R.raw.emotions_disgust,R.raw.emotions_excited,R.raw.emotions_frightened,R.raw.emotions_happy,
            R.raw.emotions_nervous,R.raw.emotions_relax,R.raw.emotions_sad,R.raw.emotions_shy,R.raw.emotions_sleepy,
            R.raw.emotions_sneaky,R.raw.emotions_sorry,R.raw.emotions_stressed,R.raw.emotions_surprised,R.raw.emotions_tense,R.raw.emotions_upset,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category4_emotions);

        mydrawer = findViewById(R.id.mydrawer);
        navigationView = findViewById(R.id.navigationdrawer);
        togglebtn = findViewById(R.id.togglebutton);
        navigationdrawer();


        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Category_Item_Data2.class);
                intent.putExtra("name", EmotionsLetters[position]);
                intent.putExtra("image", EmotionsImages[position]);
                intent.putExtra("sound", Emotionssound[position]);
                startActivity(intent);

            }
        });


    }

    private void navigationdrawer() {
        navigationView.bringToFront();
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        togglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mydrawer.isDrawerVisible(GravityCompat.START))
                    mydrawer.closeDrawer(GravityCompat.START);
                else mydrawer.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.mydrawer);
        if (mydrawer.isDrawerOpen(GravityCompat.START)){
            mydrawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (mytoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.LearnSidebar:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
            case R.id.VideosSidebar:
                startActivity(new Intent(getApplicationContext(), VideosPage.class));
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
            case R.id.BasicASlSidebar:
                startActivity(new Intent(getApplicationContext(), LearnCategory.class));
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
            case R.id.AboutSidebar:
                startActivity(new Intent(getApplicationContext(), AboutUsPage.class));
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
        }

        return true;
    }

    public void BackButton(View view) {
        finish();
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return EmotionsImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View viewl = getLayoutInflater().inflate(R.layout.category_item_3, null);
            TextView name = viewl.findViewById(R.id.Category_name_item);
            ImageView image = viewl.findViewById(R.id.Category_image_item);

            name.setText(EmotionsLetters[position]);
            image.setImageResource(EmotionsImages[position]);
            return viewl;
        }

    }
}