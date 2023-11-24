package edu.ucu.cite.deaftouchapp.FlashCardGame;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import pl.droidsonroids.gif.GifImageView;

public class FlashCardGameQuestions12FamilyMember  extends AppCompatActivity {
    GifImageView optionA,optionB;
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
                    new answerclass(R.string.FamilyMember_question_1,R.drawable.familymembers_son,R.drawable.familymembers_niece,R.drawable.familymembers_son),
                    new answerclass(R.string.FamilyMember_question_2,R.drawable.familymembers_mom,R.drawable.familymembers_nephew,R.drawable.familymembers_nephew),
                    new answerclass(R.string.FamilyMember_question_3,R.drawable.familymembers_sister,R.drawable.familymembers_mom,R.drawable.familymembers_mom),
                    new answerclass(R.string.FamilyMember_question_4,R.drawable.familymembers_brother,R.drawable.familymembers_cousin,R.drawable.familymembers_brother),
                    new answerclass(R.string.FamilyMember_question_5,R.drawable.familymembers_grandfather,R.drawable.familymembers_kid,R.drawable.familymembers_grandfather),
                    new answerclass(R.string.FamilyMember_question_6,R.drawable.familymembers_mom,R.drawable.familymembers_family,R.drawable.familymembers_family),
                    new answerclass(R.string.FamilyMember_question_7,R.drawable.familymembers_dad,R.drawable.familymembers_auntie,R.drawable.familymembers_auntie),
                    new answerclass(R.string.FamilyMember_question_8,R.drawable.familymembers_sister,R.drawable.familymembers_son,R.drawable.familymembers_sister),
                    new answerclass(R.string.FamilyMember_question_9,R.drawable.familymembers_son,R.drawable.familymembers_kid,R.drawable.familymembers_kid),
                    new answerclass(R.string.FamilyMember_question_10,R.drawable.familymembers_dad,R.drawable.familymembers_mom,R.drawable.familymembers_dad),



            };

    final int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_game_2);

        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);

        question = findViewById(R.id.question);
        questionnumber=findViewById(R.id.QuestionNumber);
//        tv_progress= findViewById(R.id.tv_progress);



        chechkout1=findViewById(R.id.selectoption);
        checkout2=findViewById(R.id.CorrectAnswer);
//        progressBar=findViewById(R.id.progress_bar);


        Collections.shuffle(Arrays.asList(questionBank));

        CurrentQuestion=questionBank[currentIndex].getQuestionid();
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

        currentIndex=(currentIndex+1)%questionBank.length;
        if(currentIndex==0)
        {

            String tmpStr10 = String.valueOf(mscore);

            String username = SharedPrefManager.getInstance(this).getUsername();

            progressDialog = new ProgressDialog(FlashCardGameQuestions12FamilyMember.this);
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

                                Intent intent = new Intent(FlashCardGameQuestions12FamilyMember.this,FlashCardGameResult.class);
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

        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setImageResource(CurrentOptionA);
        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setImageResource(CurrentOptionB);


        qn=qn+1;

        if(qn<=questionBank.length)

        {
            questionnumber.setText(qn + " / " + questionBank.length + " " +"Questions");


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
