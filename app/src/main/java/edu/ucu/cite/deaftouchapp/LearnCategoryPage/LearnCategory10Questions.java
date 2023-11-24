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

public class LearnCategory10Questions extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView gridView;
    String [] QuestionsLetters = {"How ","How Are You ","How Many ","How Much ","Ok ","What ","What Kind ","What To Do ","Whats Up ","Whats Your Name ",
                                  "When ","Where ","Where You From ","Which ","Who ","Who Is That ","Why ","You Ok "};
    int[] QuestionsImages = {
            R.drawable.questions_how,R.drawable.questions_howareyou,R.drawable.questions_howmany,R.drawable.questions_howmuch,R.drawable.questions_ok,
            R.drawable.questions_what,R.drawable.questions_whatkind,R.drawable.questions_whatdo,R.drawable.questions_whatsup,R.drawable.questions_whatsyourname,
            R.drawable.questions_when,R.drawable.questions_where,R.drawable.questions_whereyoufrom,R.drawable.questions_which,R.drawable.questions_who,
            R.drawable.questions_whoisthat,R.drawable.questions_why,R.drawable.questions_youok};

    int[] Questionssounds = {
            R.raw.questions_how,R.raw.questions_howareyou,R.raw.questions_howmany,R.raw.questions_howmuch,R.raw.questions_ok,
            R.raw.questions_what,R.raw.questions_whatkind,R.raw.questions_whattodo,R.raw.questions_whatsup,R.raw.questions_whatsyourname,
            R.raw.questions_when,R.raw.questions_where,R.raw.questions_whereyoufrom,R.raw.questions_which,R.raw.questions_who,
            R.raw.questions_whoisthat,R.raw.questions_why,R.raw.questions_youok};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_category10_questions);

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
                intent.putExtra("name", QuestionsLetters[position]);
                intent.putExtra("image", QuestionsImages[position]);
                intent.putExtra("sound", Questionssounds[position]);
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
            return QuestionsImages.length;
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

            name.setText(QuestionsLetters[position]);
            image.setImageResource(QuestionsImages[position]);
            return viewl;
        }

    }
}