package edu.ucu.cite.deaftouchapp;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.ucu.cite.deaftouchapp.LeaderBoard.Leaderboard;
import edu.ucu.cite.deaftouchapp.LeaderBoard.User_Login;
import edu.ucu.cite.deaftouchapp.LearnCategoryPage.LearnCategory1Alphabets;
import edu.ucu.cite.deaftouchapp.LearnCategoryPage.LearnCategory2Numbers;
import edu.ucu.cite.deaftouchapp.LearnCategoryPage.LearnCategory3Greetings;
import edu.ucu.cite.deaftouchapp.LearnCategoryPage.LearnCategory4Emotions;
import edu.ucu.cite.deaftouchapp.LearnCategoryPage.LearnCategory5Colors;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    Toolbar toolbar;
    ActionBarDrawerToggle mytoggle=null;
    Button togglebtn;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    SharedPreferences sharedPreferences;

    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_NAME = "name";

    RecyclerView recyclerView;
    AdapterVideos adapter;
    ArrayList<Model> list = new ArrayList<>();

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydrawer = findViewById(R.id.mydrawer);
        navigationView = findViewById(R.id.navigationdrawer);
        togglebtn = findViewById(R.id.togglebutton);
        navigationdrawer();

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // do your stuff
        } else{
            signInAnonymously();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.naview);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.getMenu().getItem(0).setCheckable(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {


                        switch (menuItem.getItemId()){



                case R.id.LearnASL:
                    return true;
                case R.id.Translate:
                    startActivity(new Intent(getApplicationContext(),TranslatePage.class));
                    finish();
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    return true;
                case R.id.Minigames:
                    startActivity(new Intent(getApplicationContext(), User_Login.class));
                    finish();
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    return true;

            }
            return false;
        });



        recyclerView = findViewById(R.id.recyclerview);
        adapter = new AdapterVideos(MainActivity.this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fetchdata();

    }


    private void fetchdata(){
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=UC5uAJOdW-zDcTvm7cYToskA&maxResults=30&key=AIzaSyDY56pGbuV51rarnQx7nhyeRDFMhQZJLQo",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("items");
                            for (int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                JSONObject jsonvideoid = jsonObject1.getJSONObject("id");
                                JSONObject jsonsnippet = jsonObject1.getJSONObject("snippet");
                                JSONObject jsonthumbnail = jsonsnippet.getJSONObject("thumbnails").getJSONObject("medium");


                                Model md = new Model();
                                if  (i!= 1 & i!=2){

                                    md.setVideoId(jsonvideoid.optString("videoId"));
                                    md.setTitle(jsonsnippet.getString("title"));
                                    md.setUrl(jsonthumbnail.getString("url"));
                                    list.add(md);

                                }


                            }

                            if (list.size() > 0){
                                adapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                CardView cardView = findViewById(R.id.videounavailable);

                cardView.setVisibility(View.VISIBLE);

            }
        });

        requestQueue.add(stringRequest);
    }


    private void signInAnonymously() {
        mAuth.signInAnonymously().addOnSuccessListener(this, new  OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                // do your stuff
            }
        })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Log.e(TAG, "signInAnonymously:FAILURE", exception);
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
//        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.mydrawer);
//        if (mydrawer.isDrawerOpen(GravityCompat.START)){
//            mydrawer.closeDrawer(GravityCompat.START);
//
//        } else {
//            super.onBackPressed();
//        }

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


    public void CategoryPage(View view) {
        Intent i = new Intent(MainActivity.this, LearnCategory.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    public void VideosPage(View view) {
        Intent i = new Intent(MainActivity.this, VideosPage.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    public void SongsPage(View view) {
        Intent i = new Intent(MainActivity.this, SongPage.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    public void Category1Alphabets(View view) {
        Intent i = new Intent(MainActivity.this, LearnCategory1Alphabets.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);

    }

    public void Category2Numbers(View view) {
        Intent i = new Intent(MainActivity.this, LearnCategory2Numbers.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);

    }

    public void Category3Greetings(View view) {
        Intent i = new Intent(MainActivity.this, LearnCategory3Greetings.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    public void Category4Emotions(View view) {
        Intent i = new Intent(MainActivity.this, LearnCategory4Emotions.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    public void Category5Colors(View view) {
        Intent i = new Intent(MainActivity.this, LearnCategory5Colors.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }


    public void leaderboard(View view) {

        Intent i = new Intent(MainActivity.this, Leaderboard.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }
}