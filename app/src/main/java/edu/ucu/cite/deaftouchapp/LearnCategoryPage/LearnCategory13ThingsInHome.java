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

public class LearnCategory13ThingsInHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView gridView;
    String [] ThingsInHomeLetters = {
            "Battery ","Blanket ","Calculator ","Chair ","Credit Card ",
            "Fork ","Gate ","House ","Key ","Knife ",
            "Mirror ","Nail Polish ","Shoes ","Spoon ","Television ",
            "Tissue ","Toothbrush ","Trash ","Utensil ","Wallet ",
    };
    int[] ThingsInHomeImages = {
            R.drawable.things_battery,R.drawable.things_blanket,R.drawable.things_calculator,R.drawable.things_chair,R.drawable.things_creditcard,
            R.drawable.things_fork,R.drawable.things_gate,R.drawable.things_house,R.drawable.things_key,R.drawable.things_knife,
            R.drawable.things_mirror,R.drawable.things_nailpolish,R.drawable.things_shoes,R.drawable.things_spoon,R.drawable.things_television,
            R.drawable.things_tissue,R.drawable.things_toothbrush,R.drawable.things_trash,R.drawable.things_utensil,R.drawable.things_wallet,};

    int[] ThingsInHomesounds = {
            R.raw.things_battery,R.raw.things_blanket,R.raw.things_calculator,R.raw.things_chair,R.raw.things_creditcard,
            R.raw.things_fork,R.raw.things_gate,R.raw.things_house,R.raw.things_key,R.raw.things_knife,
            R.raw.things_mirror,R.raw.things_nailpolish,R.raw.things_shoes,R.raw.things_spoon,R.raw.things_television,
            R.raw.things_tissue,R.raw.things_toothbrush,R.raw.things_trash,R.raw.things_utensil,R.raw.things_wallet,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category13_things_in_home);

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
                intent.putExtra("name", ThingsInHomeLetters[position]);
                intent.putExtra("image", ThingsInHomeImages[position]);
                intent.putExtra("sound", ThingsInHomesounds[position]);
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
            return ThingsInHomeImages.length;
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

            name.setText(ThingsInHomeLetters[position]);
            image.setImageResource(ThingsInHomeImages[position]);
            return viewl;
        }

    }
}