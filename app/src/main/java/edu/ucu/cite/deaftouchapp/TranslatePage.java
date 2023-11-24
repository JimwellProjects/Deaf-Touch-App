package edu.ucu.cite.deaftouchapp;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.reginald.editspinner.EditSpinner;
import com.squareup.picasso.Picasso;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.ucu.cite.deaftouchapp.LeaderBoard.User_Login;
import edu.ucu.cite.deaftouchapp.NoInternetFolder.NetworkChangeListener;
import pl.droidsonroids.gif.GifImageView;

public class TranslatePage<LocalRepository> extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MeowBottomNavigation bottomNavigation;
    NavigationView navigationView;
    DrawerLayout mydrawer;
    ActionBarDrawerToggle mytoggle = null;
    ImageView togglebtn;
    TextView info;
    StorageReference mStorageReference;
    GifImageView imageTrans;
    Button searchBtn;
    String getSearchText;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    AutoCompleteTextView actv;
    ProgressBar progressBar;

    SharedPreferences sharedPreferences;

    NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_page);



        mydrawer = findViewById(R.id.mydrawer);
        navigationView = findViewById(R.id.navigationdrawer);
        searchBtn = findViewById(R.id.searchBtn);
        togglebtn = findViewById(R.id.togglebutton);
        imageTrans =findViewById(R.id.imageTrans);
        info = findViewById(R.id.infoTrans);

        actv = findViewById(R.id.autoCompleteTextView1);

        progressBar = findViewById(R.id.progress_bar);

        String[] suggestions = getResources().getStringArray(R.array.suggestions);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,suggestions);
        actv.setAdapter(adapter);

        actv.setThreshold(1);

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
        } else {
            signInAnonymously();
        }

        navigationdrawer();
        BottomNavigationView bottomNavigationView = findViewById(R.id.naview);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setSelectedItemId(R.id.Translate);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){

                case R.id.Translate:
                    return true;

                case R.id.LearnASL:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));


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


        mStorageReference = FirebaseStorage.getInstance().getReference();

        searchBtn.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {

                    getSearchText = actv.getText().toString();
                    
                    if (getSearchText.isEmpty()){

                        Toast.makeText(TranslatePage.this, "Type a sign want to search", Toast.LENGTH_SHORT).show();

                    }else {

                        progressBar.setVisibility(View.VISIBLE);

                        StorageReference profileRef = mStorageReference.child("translations/" + getSearchText + ".gif");

                        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                progressBar.setVisibility(View.GONE);
//                                Toast.makeText(TranslatePage.this, "Sign of" + " " + getSearchText, Toast.LENGTH_SHORT).show();

                                Glide.with(TranslatePage.this).load(uri).into(new DrawableImageViewTarget(imageTrans));

                                info.setText("Sign for " + getSearchText);



                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressBar.setVisibility(View.GONE);
//                                Toast.makeText(TranslatePage.this, "No Data found", Toast.LENGTH_SHORT).show();
                                info.setText("No Data Found");


                                Glide.with(TranslatePage.this).load(R.drawable.nodatafoundsign).into(imageTrans);
                                imageTrans.getLayoutParams().height = 900;
                                imageTrans.getLayoutParams().width = 900;

                            }
                        });

                    }

                }

        });



    }

    //        No Internet Connection







    //    Firebase

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


    //   End Firebase

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
//        }else {
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

        switch (item.getItemId()) {

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

    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }

}