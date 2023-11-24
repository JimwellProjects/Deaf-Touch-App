package edu.ucu.cite.deaftouchapp.FlashCardGame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.SharedPrefManager;

public class FlashCardGame_1 extends AppCompatActivity {

    ImageView optionA,optionB;
    private TextView questionnumber,question;
    ProgressDialog progressDialog;

//    TextView tv_progress;
    private TextView chechkout1,checkout2;
    String mQuestionLiss;
    int currentIndex;
    int mscore=0;

    String newoption;


    int qn=1;
//    ProgressBar progressBar;

    int CurrentQuestion,CurrentOptionA,CurrentOptionB;


    private final answerclass[] questionBank= new answerclass[]
            {
                    new answerclass(R.string.Alphabets_question_1,R.drawable.alphabets_a,R.drawable.alphabets_b,R.drawable.alphabets_a),
                    new answerclass(R.string.Alphabets_question_2,R.drawable.alphabets_b,R.drawable.alphabets_k,R.drawable.alphabets_b),
                    new answerclass(R.string.Alphabets_question_3,R.drawable.alphabets_c,R.drawable.alphabets_o,R.drawable.alphabets_c),
                    new answerclass(R.string.Alphabets_question_4,R.drawable.alphabets_f,R.drawable.alphabets_d,R.drawable.alphabets_d),
                    new answerclass(R.string.Alphabets_question_5,R.drawable.alphabets_e,R.drawable.alphabets_x,R.drawable.alphabets_e),
                    new answerclass(R.string.Alphabets_question_6,R.drawable.alphabets_f,R.drawable.alphabets_q,R.drawable.alphabets_f),
                    new answerclass(R.string.Alphabets_question_7,R.drawable.alphabets_s,R.drawable.alphabets_g,R.drawable.alphabets_g),
                    new answerclass(R.string.Alphabets_question_8,R.drawable.alphabets_h,R.drawable.alphabets_t,R.drawable.alphabets_h),
                    new answerclass(R.string.Alphabets_question_9,R.drawable.alphabets_i,R.drawable.alphabets_u,R.drawable.alphabets_i),
                    new answerclass(R.string.Alphabets_question_10,R.drawable.alphabets_y,R.drawable.alphabets_j,R.drawable.alphabets_j),

                    new answerclass(R.string.Alphabets_question_11,R.drawable.alphabets_k,R.drawable.alphabets_z,R.drawable.alphabets_k),
                    new answerclass(R.string.Alphabets_question_12,R.drawable.alphabets_w,R.drawable.alphabets_l,R.drawable.alphabets_l),
                    new answerclass(R.string.Alphabets_question_13,R.drawable.alphabets_m,R.drawable.alphabets_a,R.drawable.alphabets_m),
                    new answerclass(R.string.Alphabets_question_14,R.drawable.alphabets_e,R.drawable.alphabets_n,R.drawable.alphabets_n),
                    new answerclass(R.string.Alphabets_question_15,R.drawable.alphabets_o,R.drawable.alphabets_x,R.drawable.alphabets_o),
                    new answerclass(R.string.Alphabets_question_16,R.drawable.alphabets_f,R.drawable.alphabets_p,R.drawable.alphabets_p),
                    new answerclass(R.string.Alphabets_question_17,R.drawable.alphabets_q,R.drawable.alphabets_c,R.drawable.alphabets_q),
                    new answerclass(R.string.Alphabets_question_18,R.drawable.alphabets_i,R.drawable.alphabets_r,R.drawable.alphabets_r),
                    new answerclass(R.string.Alphabets_question_19,R.drawable.alphabets_s,R.drawable.alphabets_t,R.drawable.alphabets_s),
                    new answerclass(R.string.Alphabets_question_20,R.drawable.alphabets_g,R.drawable.alphabets_t,R.drawable.alphabets_t),

                    new answerclass(R.string.Alphabets_question_21,R.drawable.alphabets_u,R.drawable.alphabets_h,R.drawable.alphabets_u),
                    new answerclass(R.string.Alphabets_question_22,R.drawable.alphabets_j,R.drawable.alphabets_v,R.drawable.alphabets_v),
                    new answerclass(R.string.Alphabets_question_23,R.drawable.alphabets_w,R.drawable.alphabets_n,R.drawable.alphabets_w),
                    new answerclass(R.string.Alphabets_question_24,R.drawable.alphabets_m,R.drawable.alphabets_x,R.drawable.alphabets_x),
                    new answerclass(R.string.Alphabets_question_25,R.drawable.alphabets_y,R.drawable.alphabets_q,R.drawable.alphabets_y),
                    new answerclass(R.string.Alphabets_question_26,R.drawable.alphabets_l,R.drawable.alphabets_z,R.drawable.alphabets_z)

            };


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_game_1);

        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);

        question = findViewById(R.id.question);
        questionnumber=findViewById(R.id.QuestionNumber);
//        tv_progress= findViewById(R.id.tv_progress);



        chechkout1=findViewById(R.id.selectoption);
        checkout2=findViewById(R.id.CorrectAnswer);
//        progressBar=findViewById(R.id.progress_bar);



            Collections.shuffle(Arrays.asList(questionBank));




            CurrentQuestion = questionBank[currentIndex].getQuestionid();
            question.setText(CurrentQuestion);

            CurrentOptionA=questionBank[currentIndex].getOptionA();
            optionA.setImageResource(CurrentOptionA);

            CurrentOptionB=questionBank[currentIndex].getOptionB();
            optionB.setImageResource(CurrentOptionB);



        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newoption = "option1";
                checkAnswer(CurrentOptionA);



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        updateQuestion();
                        overridePendingTransition(R.anim.fadein,R.anim.fadeout);

                    }
                },2000);

            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newoption = "option2";
                checkAnswer(CurrentOptionB);



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        updateQuestion();
                        overridePendingTransition(R.anim.fadein,R.anim.fadeout);

                    }
                },2000);



            }
        });



    }


    @SuppressLint("ResourceAsColor")
    private void checkAnswer(int userSelection) {

        int correctanswer=questionBank[currentIndex].getAnswerid();

        chechkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m= chechkout1.getText().toString().trim();
        String n=checkout2.getText().toString().trim();

        if(m.equals(n))
        {
            RelativeLayout imageView = findViewById(R.id.correctbtn);
            imageView.setVisibility(View.VISIBLE);

            final MediaPlayer mp = MediaPlayer.create(this, R.raw.correctansweraudio2);
            mp.start();


            if (newoption.equals("option1")){
                optionA.setBackgroundResource(R.drawable.correct_option_border_bg);
                optionB.setBackgroundResource(R.drawable.default_option_border_bg_2);
            }

            if (newoption.equals("option2")){
                optionB.setBackgroundResource(R.drawable.correct_option_border_bg);
                optionA.setBackgroundResource(R.drawable.default_option_border_bg_2);
            }


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    imageView.setVisibility(View.GONE);

                    optionA.setBackgroundResource(R.drawable.default_option_border_bg_2);
                    optionB.setBackgroundResource(R.drawable.default_option_border_bg_2);

                }
            },2000);

            mscore=mscore+1;

        }
        else
        {

            RelativeLayout imageView = findViewById(R.id.wrongbtn);
            imageView.setVisibility(View.VISIBLE);


            final MediaPlayer mp = MediaPlayer.create(this, R.raw.wrongansweraudio3);
            mp.start();


            if (newoption.equals("option1")){
                optionA.setBackgroundResource(R.drawable.wrong_option_border_bg);
                optionB.setBackgroundResource(R.drawable.default_option_border_bg_2);
            }

            if (newoption.equals("option2")){
                optionB.setBackgroundResource(R.drawable.wrong_option_border_bg);
                optionA.setBackgroundResource(R.drawable.default_option_border_bg_2);
            }


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    imageView.setVisibility(View.GONE);

                    optionA.setBackgroundResource(R.drawable.default_option_border_bg_2);
                    optionB.setBackgroundResource(R.drawable.default_option_border_bg_2);

                }
            },2000);


        }


    }


    @SuppressLint("SetTextI18n")
    private void updateQuestion() {

            currentIndex = (currentIndex + 1) % 9;

        if(currentIndex==0)
        {

            String tmpStr10 = String.valueOf(mscore);

            String username = SharedPrefManager.getInstance(this).getUsername();

            progressDialog = new ProgressDialog(FlashCardGame_1.this);
            progressDialog.setMessage("Please wait....");
            StringRequest stringRequest = new StringRequest(Request.Method.POST,"https://deagtouch.000webhostapp.com/DeafTouch/InsertScore.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            try {
                                String tmpStr10 = String.valueOf(mscore);
                                JSONObject jsonObject = new JSONObject(response);
                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG);

                                Intent intent = new Intent(FlashCardGame_1.this,FlashCardGameResult.class);
                                intent.putExtra("mscore1",tmpStr10 );
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                                overridePendingTransition(R.anim.fadein,R.anim.fadeout);

                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e("anyText", response);
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("username", username);
                    params.put("newscore", tmpStr10 );


                    return params;

                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }



            CurrentQuestion = questionBank[currentIndex].getQuestionid();
            question.setText(CurrentQuestion);

            CurrentOptionA = questionBank[currentIndex].getOptionA();
            optionA.setImageResource(CurrentOptionA);

            CurrentOptionB = questionBank[currentIndex].getOptionB();
            optionB.setImageResource(CurrentOptionB);




        qn=qn+1;

        if(qn<=questionBank.length)

        {
            questionnumber.setText(qn + " / " + "10" + " " +"Questions");


        }



    }

    @Override
    public void onBackPressed() {
        new android.app.AlertDialog.Builder(this)
                .setMessage("Are You Sure Want To Quit This Game?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(getApplicationContext(), FlashCardGameSelectCategories.class));
                        finish();
                        overridePendingTransition(R.anim.fadein,R.anim.fadeout);

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}