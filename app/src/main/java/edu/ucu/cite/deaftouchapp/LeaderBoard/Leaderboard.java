package edu.ucu.cite.deaftouchapp.LeaderBoard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.SharedPrefManager;
import edu.ucu.cite.deaftouchapp.userlist;

public class Leaderboard extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<userlist> productList;
    UserAdapter adapter;
    private RecyclerView.LayoutManager manager;
    TextView viewrank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);


        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.userreclyerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();



        recyclerView.setAdapter(adapter);


        loadProducts();
    }

    public void login(View view) {
        Intent i = new Intent(Leaderboard.this, User_Login.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);


    }



    private void loadProducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constant.URL_UserScore,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        productList.clear();
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);

                                //adding the product to product list
                                productList.add(new userlist(
                                        product.getString("Id"),
                                        product.getString("Username"),
                                        product.getString("Score")




                                ));

                            }

                            //creating adapter object and setting it to recyclerview
                            adapter = new UserAdapter(Leaderboard.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("anyText",response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}