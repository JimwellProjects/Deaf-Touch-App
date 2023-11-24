package edu.ucu.cite.deaftouchapp;

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

public class SignQuizGameSelectCategories extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;

    GridView SignQuizSelect;

    String [] SignQuizCategoriesTitle = {"Alphabets","Numbers","Greetings","Emotions","Colors","Animals","Foods","Everything We Do","Months","Questions","BodyParts", "Family Members","Shapes", "Things In Home"};
    int[] SignQuizCategoriesImages = {
            R.drawable.alpabhets,R.drawable.numbers,R.drawable.greetings, R.drawable.emotion, R.drawable.colors,
            R.drawable.animal, R.drawable.foods, R.drawable.everythingwedo, R.drawable.calendar, R.drawable.question,
            R.drawable.bodyparts, R.drawable.familymember,R.drawable.shapes,R.drawable.thingsinhome};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_quiz_game_select_categories);

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

                if (SignQuizCategoriesTitle[position] == "Alphabets") {
                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Numbers"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions2Numbers.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Greetings"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions3Greetings.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Emotions"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions4Emotions.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Colors"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions5Colors.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();

                }else if(SignQuizCategoriesTitle[position] == "Animals"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions6Animals.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();
                }else if(SignQuizCategoriesTitle[position] == "Foods"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions7Foods.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();
                }else if(SignQuizCategoriesTitle[position] == "Everything We Do"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions8EverythingWeDo.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();
                }else if(SignQuizCategoriesTitle[position] == "Months"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions9Months.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();
                }
                else if(SignQuizCategoriesTitle[position] == "Questions"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions10Questions.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();
                }
                else if(SignQuizCategoriesTitle[position] == "BodyParts"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this, SignQuizGameQuestions11PartOfTheBody.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();
                }
                else if(SignQuizCategoriesTitle[position] == "Family Members"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this,  SignQuizGameQuestions12FamilyMember.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();
                }
                else if(SignQuizCategoriesTitle[position] == "Shapes"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this,  SignQuizGameQuestions13Shapes.class);
//                    intent.putExtra("USER_NAME", mUsername);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finish();
                }

                else if(SignQuizCategoriesTitle[position] == "Things In Home"){

                    Intent intent = new Intent(SignQuizGameSelectCategories.this,  SignQuizGameQuestions14ThingsInHome.class);
//                    intent.putExtra("USER_NAME", mUsername);
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
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
            case R.id.VideosSidebar:
                startActivity(new Intent(getApplicationContext(),VideosPage.class));
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
            case R.id.BasicASlSidebar:
                startActivity(new Intent(getApplicationContext(),LearnCategory.class));
                finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                break;
            case R.id.AboutSidebar:
                startActivity(new Intent(getApplicationContext(),AboutUsPage.class));
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