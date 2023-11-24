package edu.ucu.cite.deaftouchapp.GuessTheSignGame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.Random;

import edu.ucu.cite.deaftouchapp.AboutUsPage;
import edu.ucu.cite.deaftouchapp.LearnCategory;
import edu.ucu.cite.deaftouchapp.MainActivity;
import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.SharedPrefManager;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions10Questions;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions2Numbers;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions3Greetings;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions4Emotions;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions5Colors;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions6Animals;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions7Foods;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions8EverythingWeDo;
import edu.ucu.cite.deaftouchapp.SignQuizGameQuestions9Months;
import edu.ucu.cite.deaftouchapp.SignQuizGameSelectCategories;
import edu.ucu.cite.deaftouchapp.VideosPage;


public class GuessTheSignGameSelectCategories extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView SignQuizSelect;

    String [] SignQuizCategoriesTitle = {"Greetings","Emotions","Colors","Animals","Foods","Everything We Do","Months","Questions","BodyParts","Family Members"};
    int[] SignQuizCategoriesImages = {R.drawable.greetings, R.drawable.emotion, R.drawable.colors,
            R.drawable.animal, R.drawable.foods, R.drawable.everythingwedo, R.drawable.calendar, R.drawable.question,R.drawable.bodyparts,R.drawable.familymember};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_sign_game_select_categories);
        mydrawer = findViewById(R.id.mydrawer);
        navigationView = findViewById(R.id.navigationdrawer);
        togglebtn = findViewById(R.id.togglebutton);
        navigationdrawer();

//        String mUsername = getIntent().getExtras().getString("USER_NAME");

        TextView DisplayUsername = findViewById(R.id.welcomeuser);

        String username = SharedPrefManager.getInstance(this).getUsername();

        if (username != null){
            DisplayUsername.setText("Hi," + " " +username);
        }


        SignQuizSelect = findViewById(R.id.SignQuizSelect);

        CustomAdapter1 customAdapter = new CustomAdapter1();
        SignQuizSelect.setAdapter(customAdapter);

        SignQuizSelect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if(SignQuizCategoriesTitle[position] == "Greetings"){

                    Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Greetings_Game1.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Emotions"){

                    Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Emotions_Game1.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Colors"){
                    Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Colors_Game1.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Animals"){

                    Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Animals_Game1.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Foods"){

                    Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Foods_Game1.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Everything We Do"){


                    Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Ewd_Game1.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Months"){

                    Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Months_Game1.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }
                else if(SignQuizCategoriesTitle[position] == "Questions"){

                    Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Questions_Game1.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }
                    else if(SignQuizCategoriesTitle[position] == "BodyParts"){

                        Intent intent = new Intent(GuessTheSignGameSelectCategories.this, Bodyparts_Game1.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                        finish();

                    }
                    else if(SignQuizCategoriesTitle[position] == "Family Members"){

                        Intent intent = new Intent(GuessTheSignGameSelectCategories.this, FamilyMember_Game1.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                        finish();

                    }


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
    }


    private class CustomAdapter1 extends BaseAdapter {
        @Override
        public int getCount() {
            return SignQuizCategoriesImages.length;
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

            View viewl = getLayoutInflater().inflate(R.layout.select_signquiz_category, null);
            TextView name1 = viewl.findViewById(R.id.Category_name_item);
            ImageView image1 = viewl.findViewById(R.id.Category_image_item);

            name1.setText(SignQuizCategoriesTitle[position]);
            image1.setImageResource(SignQuizCategoriesImages[position]);
            return viewl;
        }
    }
}