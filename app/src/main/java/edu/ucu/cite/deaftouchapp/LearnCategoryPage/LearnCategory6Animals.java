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

public class LearnCategory6Animals extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView gridView;
    String [] AnimalsLetters = {"Alligator","Bear ","Bird ","Cat ","Cow ","Dog ","Duck ","Elephant ","Fish ","Frog ","Giraffe ","Lion ","Mouse ","Owl ","Pig ","Rat ","Snake ","Tiger ","Wolf ","Zibra "};

    int[] AnimalsImages = {R.drawable.animals_aligator,R.drawable.animals_bear,
            R.drawable.animals_bird,R.drawable.animals_cat,R.drawable.animals_cow,
            R.drawable.animals_dog,R.drawable.animals_duck,R.drawable.animals_elephant,
            R.drawable.animals_fish,R.drawable.animals_frog,R.drawable.animals_giraffe,
            R.drawable.animals_lion,R.drawable.animals_mouse,R.drawable.animals_owl,
            R.drawable.animals_pig,R.drawable.animals_rat,R.drawable.animals_snake,
            R.drawable.animals_tiger,R.drawable.animals_wolf,R.drawable.animals_zibra,
            };

    int[] Animalssound = {R.raw.animals_alligator,R.raw.animals_bear,
            R.raw.animals_bird,R.raw.animals_cat,R.raw.animals_cow,
            R.raw.animals_dog,R.raw.animals_duck,R.raw.animals_elephant,
            R.raw.animals_fish,R.raw.animals_frog,R.raw.animals_giraffe,
            R.raw.animals_lion,R.raw.animals_mouse,R.raw.animals_owl,
            R.raw.animals_pig,R.raw.animals_rat,R.raw.animals_snake,
            R.raw.animals_tiger,R.raw.animals_wolf,R.raw.animals_zibra,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category6_animals);

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
                intent.putExtra("name", AnimalsLetters[position]);
                intent.putExtra("image", AnimalsImages[position]);
                intent.putExtra("sound", Animalssound[position]);
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
            return AnimalsImages.length;
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

            name.setText(AnimalsLetters[position]);
            image.setImageResource(AnimalsImages[position]);
            return viewl;
        }

    }
}