package edu.ucu.cite.deaftouchapp.LeaderBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.RequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import edu.ucu.cite.deaftouchapp.R;

public class User_Register extends AppCompatActivity implements View.OnClickListener {

    EditText UsernameRegister;
    Button btnsaveregister;
    ProgressBar progressBar;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__register);

        UsernameRegister = findViewById(R.id.user_register);
        btnsaveregister = findViewById(R.id.user_btn_register);
        progressBar = findViewById(R.id.progress);


        btnsaveregister.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);





    }

    @Override
    public void onClick(View v) {
        if (v == btnsaveregister)

            if (UsernameRegister.getText().toString().isEmpty()){
                UsernameRegister.setError("Please Register Username");
            }else {
                registerUser();
            }

        
    }

    private void registerUser() {

        final String username = UsernameRegister.getText().toString().trim();

        if (username.isEmpty()){
                    UsernameRegister.setError("Please enter your Middlename");
                    UsernameRegister.requestFocus();
        }

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constant.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            if (!jsonObject.getBoolean("error")) {

                                Intent i = new Intent(User_Register.this, User_Login.class);
                                startActivity(i);
                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                            }else {

                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();

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
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username",username);


                return params;

            }


        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}