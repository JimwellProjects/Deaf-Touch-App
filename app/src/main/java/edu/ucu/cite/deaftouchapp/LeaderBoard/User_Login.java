package edu.ucu.cite.deaftouchapp.LeaderBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import edu.ucu.cite.deaftouchapp.MainActivity;
import edu.ucu.cite.deaftouchapp.MiniGamesPage;
import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.SharedPrefManager;

public class User_Login extends AppCompatActivity implements View.OnClickListener {

    EditText UsernameLogin;
    Button btnsaverlogin;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__login);


        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, MiniGamesPage.class));
            return;
        }

        UsernameLogin = findViewById(R.id.user_login);
        btnsaverlogin = findViewById(R.id.user_btn_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        btnsaverlogin.setOnClickListener(this);
    }

    public void UserRegister(View view) {
        Intent i = new Intent(User_Login.this, User_Register.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    @Override
    public void onClick(View v) {
        if(v == btnsaverlogin){
            if (UsernameLogin.getText().toString().isEmpty()){
                UsernameLogin.setError("Please Enter Username");
            }else {
                userLogin();
            }
        }
    }

    private void userLogin(){

    final String username = UsernameLogin.getText().toString().trim();


        progressDialog.show();

    StringRequest stringRequest = new StringRequest(
            Request.Method.POST,
            Constant.URL_LOGIN,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        if(!jsonObject.getBoolean("error")){
                            SharedPrefManager.getInstance(getApplicationContext())
                                    .userLogin(
                                            jsonObject.getInt("Id"),
                                            jsonObject.getString("username"),
                                            jsonObject.getString("score"),
                                            jsonObject.getString("myrank")
                                    );
                            Intent i = new Intent(User_Login.this, MiniGamesPage.class);
                            startActivity(i);
                            overridePendingTransition(R.anim.fadein,R.anim.fadeout);


                        }else{
                            Toast.makeText(
                                    getApplicationContext(),
                                    jsonObject.getString("message"),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("anyText",response);
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("username", username);

            return params;
        }

    };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
}

    public void backbuttonimage(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        finish();
    }
}