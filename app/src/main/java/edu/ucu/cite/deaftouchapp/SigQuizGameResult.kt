package edu.ucu.cite.deaftouchapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SigQuizGameResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_quiz_game_result)






        var tv_name: TextView
        tv_name = findViewById(R.id.tv_name)


        val username = SharedPrefManager.getInstance(this).username

        if (username != null) {
            tv_name.text = "Hi, $username "
        }

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        var tv_score: TextView
        tv_score = findViewById(R.id.tv_score)
        tv_score.text = "Your Score is $correctAnswer out of $totalQuestions"

        if (correctAnswer >=0 && correctAnswer <=3){

            var tv_congratulations: TextView
            tv_congratulations = findViewById(R.id.tv_congratulations)
            tv_congratulations.text ="Poor!"

        }else if(correctAnswer >=4 && correctAnswer <=6){

            var tv_congratulations: TextView
            tv_congratulations = findViewById(R.id.tv_congratulations)
            tv_congratulations.text ="Good!"

        }else if(correctAnswer >=6 && correctAnswer <=9){

            var tv_congratulations: TextView
            tv_congratulations = findViewById(R.id.tv_congratulations)
            tv_congratulations.text ="Very Good!"

        }else if(correctAnswer >10){

            var tv_congratulations: TextView
            tv_congratulations = findViewById(R.id.tv_congratulations)
            tv_congratulations.text ="Excellent!"

        }


        var btn_finish: TextView
        btn_finish = findViewById(R.id.btn_finish)
        btn_finish.setOnClickListener {
            startActivity(Intent(applicationContext, SignQuizGameSelectCategories::class.java))
            overridePendingTransition(R.anim.fadein, R.anim.fadeout)
            finish()
        }

    }

    fun backbuttonimage(view: View?) {
        startActivity(Intent(applicationContext, MiniGamesPage::class.java))
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        finish()
    }


    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setMessage("Are You Sure Want To Quit This Game?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, which ->
                    startActivity(Intent(applicationContext, MiniGamesPage::class.java))
                    finish()
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout)
                }
                .setNegativeButton("No", null)
                .show()
    }

    fun ExitGame(view: View) {
        startActivity(Intent(applicationContext, MiniGamesPage::class.java))
        finish()
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
    }
}