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

public class LearnCategory3Greetings extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView gridView;
    String [] GreetingsLetters = {"Good Afternoon ","Good Bye ","Good Day ","Good Evening ","Good Morning ","Good To See You ","Hello ","How Are You ","How Is It Going "
            ,"How Old Are You ","Im Fine ","Long Time No See ","Nice To Meet You ","Thank You ","Welcome ","Whats Going On ","Whats Your Name "
        };
    int[] GreetingsImages = {
            R.drawable.greetings_goodafternoon,R.drawable.greetings_goodbye,R.drawable.greetings_goodday,
            R.drawable.greetings_goodevening,R.drawable.greetings_goodmorning,R.drawable.greetings_goodtoseeyou,
            R.drawable.greetings_hello,R.drawable.greetings_howareyou,R.drawable.greetings_howisitgoing,
            R.drawable.greetings_howoldareyou,R.drawable.greetings_imfine,R.drawable.greetings_longtimenosee,
            R.drawable.greetings_nicetomeetyou,R.drawable.greetings_thankyou,R.drawable.greetings_welcome,
            R.drawable.greetings_whatsgoingon,R.drawable.greetings_whatsyourname};

    int[] Greetingssound ={R.raw.greetings_goodafternoon,R.raw.greetings_goodbye,R.raw.greetings_goodday,R.raw.greetings_goodevening,R.raw.greetings_goodmorning,
            R.raw.greetings_goodtoseeyou,R.raw.greetings_hello,R.raw.greetings_howareyou,R.raw.greetings_howisitgoing,


            R.raw.greetings_howoldareyou,R.raw.greetings_imfine,R.raw.greetings_longtimenosee,R.raw.greetings_nicetomeetyou,R.raw.greetings_thankyou,
            R.raw.greetings_welcome,R.raw.greetings_whatsgoingon,R.raw.greetings_whatsyourname};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category3_greetings);

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
                intent.putExtra("name", GreetingsLetters[position]);
                intent.putExtra("image", GreetingsImages[position]);
                intent.putExtra("sound", Greetingssound[position]);
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
            return GreetingsImages.length;
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


            name.setText(GreetingsLetters[position]);
            image.setImageResource(GreetingsImages[position]);
            return viewl;
        }

    }



}