package edu.ucu.cite.deaftouchapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import edu.ucu.cite.deaftouchapp.LeaderBoard.Leaderboard;
import edu.ucu.cite.deaftouchapp.LeaderBoard.User_Login;

public class MiniGamesPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    ImageView togglebtn;


    TextView textView_name;
    Button button_logout;

    Dialog myDialog;

    String username;

    TextView popusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_games_page);

        mydrawer = findViewById(R.id.mydrawer);
        navigationView = findViewById(R.id.navigationdrawer);
        togglebtn = findViewById(R.id.togglebutton);
        navigationdrawer();

        myDialog = new Dialog(this);

        textView_name = findViewById(R.id.text_fullname);



        username = SharedPrefManager.getInstance(this).getUsername();

        if (username != null){
            textView_name.setText("Hi," + " " +username +" Let's Play");
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.naview);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setSelectedItemId(R.id.Minigames);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){

                case R.id.Minigames:
                    return true;

                case R.id.LearnASL:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finishAffinity();
                    return true;



                case R.id.Translate:
                    startActivity(new Intent(getApplicationContext(),TranslatePage.class));
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    finishAffinity();
                    return true;
            }

            return false;
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
        new AlertDialog.Builder(this)
                .setMessage("Are You Sure Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finishAffinity();

                    }
                })
                .setNegativeButton("No", null)
                .show();
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

    public void CategoryGame1(View view) {
        Intent i = new Intent(MiniGamesPage.this,FlashCardGameWelcomePage.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        isFinishing();
    }

    public void SignQuizGame(View view) {
        Intent i = new Intent(MiniGamesPage.this,SignQuizGameWelcomePage.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        isFinishing();
    }

    public void GuessSignGame(View view) {
        Intent i = new Intent(MiniGamesPage.this,GuessSignGameWelcomePage.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        isFinishing();
    }

    public void ShowPopUser(View view) {

        ImageView txtclose;
        Button logout_button;

        myDialog.setContentView(R.layout.profile_pop_up);
        popusername = myDialog.findViewById(R.id.popupusername);

        popusername.setText(username);



        txtclose =(ImageView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void btn_logout(View view) {
        SharedPrefManager.getInstance(this).logout();
        finishAffinity();
        Intent intent5 = new Intent(MiniGamesPage.this, User_Login.class);
        startActivity(intent5);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    public void LeaderBoardPage(View view) {

        Intent i = new Intent(MiniGamesPage.this, Leaderboard.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        isFinishing();

        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}