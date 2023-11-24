package edu.ucu.cite.deaftouchapp.SignQuizGame2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

import edu.ucu.cite.deaftouchapp.FlashCardGame.FlashCardGameResult;
import edu.ucu.cite.deaftouchapp.FlashCardGame.FlashCardGameSelectCategories;
import edu.ucu.cite.deaftouchapp.FlashCardGame.FlashCardGame_1;
import edu.ucu.cite.deaftouchapp.FlashCardGame.answerclass;
import edu.ucu.cite.deaftouchapp.MainActivity;
import edu.ucu.cite.deaftouchapp.R;
import edu.ucu.cite.deaftouchapp.SignQuizGame;

public class SignQuizGame_1 extends AppCompatActivity {

    TextView optionA,optionB,optionC,optionD;
    private TextView questionnumber,question;
    ImageView image;

    //    TextView tv_progress;
    private TextView chechkout1,checkout2;
    String mQuestionLiss;
    int currentIndex;
    int mscore=0;


    int qn=1;
//    ProgressBar progressBar;

    int CurrentQuestion,CurrentImage,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;


    private final answerclass2[] questionBank= new answerclass2[]
            {
                    new answerclass2(R.string.SignQuizGameQuestions,R.drawable.alphabets_a,R.string.Alphabets_A,R.string.Alphabets_B,R.string.Alphabets_C,R.string.Alphabets_D,R.string.answer1),
                    new answerclass2(R.string.SignQuizGameQuestions,R.drawable.alphabets_x,R.string.Alphabets_A,R.string.Alphabets_B,R.string.Alphabets_C,R.string.Alphabets_D,R.string.answer2),




            };

    final int PROGRESS_BAR = (int) Math.ceil(100/questionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_quiz_game_1);

        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);

        image = findViewById(R.id.signimage);

        question = findViewById(R.id.question);
        questionnumber=findViewById(R.id.QuestionNumber);
//        tv_progress= findViewById(R.id.tv_progress);



        chechkout1=findViewById(R.id.selectoption);
        checkout2=findViewById(R.id.CorrectAnswer);
//        progressBar=findViewById(R.id.progress_bar);

        Collections.shuffle(Arrays.asList(questionBank));



        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);

        CurrentImage=questionBank[currentIndex].getImageid();
        image.setImageResource(CurrentImage);

        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);

        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);

        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);

        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

    private void checkAnswer(int userSelection) {

        int correctanswer=questionBank[currentIndex].getAnswerid();

        chechkout1.setText(userSelection);
        checkout2.setText(correctanswer);

        String m= chechkout1.getText().toString().trim();
        String n=checkout2.getText().toString().trim();

        if(m.equals(n))
        {
            ImageView imageView = findViewById(R.id.correctbtn);
            imageView.setVisibility(View.VISIBLE);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    imageView.setVisibility(View.GONE);

                }
            },2000);

            Toast.makeText(getApplicationContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
            mscore=mscore+1;

        }
        else
        {

            ImageView imageView = findViewById(R.id.wrongbtn);
            imageView.setVisibility(View.VISIBLE);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                    imageView.setVisibility(View.GONE);

                }
            },2000);

            Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();

        }







    }


    @SuppressLint("SetTextI18n")
    private void updateQuestion() {

        currentIndex=(currentIndex+1)%questionBank.length;
        if(currentIndex==0)
        {

            String tmpStr10 = String.valueOf(mscore);

            Intent intent = new Intent(SignQuizGame_1.this, MainActivity.class);
            intent.putExtra("mscore1",tmpStr10 );
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.fadein,R.anim.fadeout);

        }

        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);

        CurrentImage=questionBank[currentIndex].getImageid();
        image.setImageResource(CurrentImage);

        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);

        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);

        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);

        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);


        qn=qn+1;

        if(qn<=questionBank.length)

        {
            questionnumber.setText(qn + " / " + questionBank.length + " " +"Questions");

//            tv_progress.setText(qn + "/" + questionBank.length);

        }
//        progressBar.incrementProgressBy(CurrentQuestion);



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