package edu.ucu.cite.deaftouchapp.LearnCategoryPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;

import edu.ucu.cite.deaftouchapp.AboutUsPage;
import edu.ucu.cite.deaftouchapp.LearnCategory;
import edu.ucu.cite.deaftouchapp.MainActivity;
import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.VideosPage;

public class LearnCategory11PartsOfTheBody extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView gridView;
    String [] PartsBodyLetters = {"Arm ","Back ","Bald ","Body ","Ear ","Eyes ","Face ","Foot ","Hair ","Hands ","Head ","Heart ","Mouth ","Neck ","Nose ","Stomach ",};
    int[] PartsBodyImages = {
            R.drawable.bodyparts_arm,R.drawable.bodyparts_back,R.drawable.bodyparts_bald,R.drawable.bodyparts_body,R.drawable.bodyparts_ear,
            R.drawable.bodyparts_eyes,R.drawable.bodyparts_face,R.drawable.bodyparts_foot,R.drawable.bodyparts_hair,R.drawable.bodyparts_hands,
            R.drawable.bodyparts_head,R.drawable.bodyparts_heart,R.drawable.bodyparts_mouth,R.drawable.bodyparts_neck,R.drawable.bodyparts_nose,R.drawable.bodyparts_stomach};

    int[] PartsBodysounds = {
            R.raw.partsofbody_arm,R.raw.partsofbody_back,R.raw.partsofbody_bald,R.raw.partsofbody_body,R.raw.partsofbody_ear,
            R.raw.partsofbody_eyes,R.raw.partsofbody_face,R.raw.partsofbody_foot,R.raw.partsofbody_hair,R.raw.partsofbody_hands,
            R.raw.partsofbody_head,R.raw.partsofbody_heart,R.raw.partsofbody_mouth,R.raw.partsofbody_neck,R.raw.partsofbody_nose,
            R.raw.partsofbody_stomach
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category11_parts_of_the_body);

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
                intent.putExtra("name", PartsBodyLetters[position]);
                intent.putExtra("image", PartsBodyImages[position]);
                intent.putExtra("sound", PartsBodysounds[position]);
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
            return PartsBodyImages.length;
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

            name.setText(PartsBodyLetters[position]);
            image.setImageResource(PartsBodyImages[position]);
            return viewl;
        }

    }
}