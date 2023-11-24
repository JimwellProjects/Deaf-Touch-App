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

public class LearnCategory1Alphabets extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView gridView;
    String [] AlphabetsLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    int[] AlphabetsImages = {R.drawable.alphabets_a,R.drawable.alphabets_b,R.drawable.alphabets_c,R.drawable.alphabets_d,R.drawable.alphabets_e,R.drawable.alphabets_f,
            R.drawable.alphabets_g,R.drawable.alphabets_h,R.drawable.alphabets_i,R.drawable.alphabets_j,R.drawable.alphabets_k,R.drawable.alphabets_l,R.drawable.alphabets_m,
            R.drawable.alphabets_n,R.drawable.alphabets_o,R.drawable.alphabets_p,R.drawable.alphabets_q,R.drawable.alphabets_r,R.drawable.alphabets_s,R.drawable.alphabets_t,
            R.drawable.alphabets_u,R.drawable.alphabets_v,R.drawable.alphabets_w,R.drawable.alphabets_x,R.drawable.alphabets_y,R.drawable.alphabets_z};

    int[] Alphabetssound = {R.raw.alphabets_a,R.raw.alphabets_b,R.raw.alphabets_c,R.raw.alphabets_d,R.raw.alphabets_e,
            R.raw.alphabets_f,R.raw.alphabets_g,R.raw.alphabets_h,R.raw.alphabets_i,R.raw.alphabets_j,R.raw.alphabets_k,
            R.raw.alphabets_l,R.raw.alphabets_m,R.raw.alphabets_n,R.raw.alphabets_o,R.raw.alphabets_p,R.raw.alphabets_q,
            R.raw.alphabets_r,R.raw.alphabets_s,R.raw.alphabets_t,R.raw.alphabets_u,R.raw.alphabets_v,R.raw.alphabets_w,
            R.raw.alphabets_x,R.raw.alphabets_y,R.raw.alphabets_z};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category1_alphabets);

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
                Intent intent = new Intent(getApplicationContext(), Category_Item_Data.class);
                intent.putExtra("name", AlphabetsLetters[position]);
                intent.putExtra("image", AlphabetsImages[position]);
                intent.putExtra("sound", Alphabetssound[position]);
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
            return AlphabetsImages.length;
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
            View viewl = getLayoutInflater().inflate(R.layout.category_item, null);
            TextView name = viewl.findViewById(R.id.Category_name_item);
            ImageView image = viewl.findViewById(R.id.Category_image_item);

            name.setText(AlphabetsLetters[position]);
            image.setImageResource(AlphabetsImages[position]);
            return viewl;
        }
    }
}