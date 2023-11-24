package edu.ucu.cite.deaftouchapp

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import pl.droidsonroids.gif.GifImageView
import java.util.*
import kotlin.collections.ArrayList

class SignQuizGameQuestions13Shapes  : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUsername: String? = null
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_quiz_game_questions2)

        mUsername = intent.getStringExtra("USER_NAME")

        mQuestionList  = Constants13.getQuestions()
        Collections.shuffle(mQuestionList)
        setQuestion()

        var tv_option_one: TextView
        tv_option_one = findViewById(R.id.tv_option_one)

        var tv_option_two: TextView
        tv_option_two = findViewById(R.id.tv_option_two)

        var tv_option_three: TextView
        tv_option_three = findViewById(R.id.tv_option_three)

        var tv_option_four: TextView
        tv_option_four = findViewById(R.id.tv_option_four)

        var btn_submit: Button
        btn_submit = findViewById(R.id.btn_submit)

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)

        btn_submit.setOnClickListener(this)


    }


    private fun setQuestion(){

        val question = mQuestionList!![mCurrentPosition-1]
        defaultOptionsView()

//        Collections.shuffle(mQuestionList)


        if (mCurrentPosition == mQuestionList!!.size){

            var btn_submit: Button
            btn_submit = findViewById(R.id.btn_submit)
            btn_submit.text = "FINISH"

        }else{
            var btn_submit: Button
            btn_submit = findViewById(R.id.btn_submit)
            btn_submit.text = "SUBMIT"
        }


        var progressBar: ProgressBar
        progressBar = findViewById(R.id.progressBar)
        progressBar.progress = mCurrentPosition

        var tv_progress: TextView
        tv_progress = findViewById(R.id.tv_progress)
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        var tv_question: TextView
        tv_question = findViewById(R.id.tv_question)
        tv_question.text = question.question

        var iv_image: GifImageView
        iv_image = findViewById(R.id.iv_image)
        iv_image.setImageResource(question.image)

        var tv_option_one: TextView
        tv_option_one = findViewById(R.id.tv_option_one)
        tv_option_one.text = question.optionOne

        var tv_option_two: TextView
        tv_option_two = findViewById(R.id.tv_option_two)
        tv_option_two.text = question.optionTwo

        var tv_option_three: TextView
        tv_option_three = findViewById(R.id.tv_option_three)
        tv_option_three.text = question.optionThree

        var tv_option_four: TextView
        tv_option_four = findViewById(R.id.tv_option_four)
        tv_option_four.text = question.optionFour



    }

    private fun defaultOptionsView() {

        var tv_option_one: TextView
        tv_option_one = findViewById(R.id.tv_option_one)

        var tv_option_two: TextView
        tv_option_two = findViewById(R.id.tv_option_two)

        var tv_option_three: TextView
        tv_option_three = findViewById(R.id.tv_option_three)

        var tv_option_four: TextView
        tv_option_four = findViewById(R.id.tv_option_four)

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this@SignQuizGameQuestions13Shapes,
                    R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {

        var tv_option_one: TextView
        tv_option_one = findViewById(R.id.tv_option_one)

        var tv_option_two: TextView
        tv_option_two = findViewById(R.id.tv_option_two)

        var tv_option_three: TextView
        tv_option_three = findViewById(R.id.tv_option_three)

        var tv_option_four: TextView
        tv_option_four = findViewById(R.id.tv_option_four)

        when (v?.id) {

            R.id.tv_option_one -> {

                selectedOptionView(tv_option_one, 1)
            }

            R.id.tv_option_two -> {

                selectedOptionView(tv_option_two, 2)
            }

            R.id.tv_option_three -> {

                selectedOptionView(tv_option_three, 3)
            }

            R.id.tv_option_four -> {

                selectedOptionView(tv_option_four, 4)
            }

            R.id.btn_submit -> {

                if (mSelectedOptionPosition == 0) {

//                    Toast.makeText(this@SignQuizGameQuestions, "Please Choose An Answer", Toast.LENGTH_SHORT).show()
                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()

                        }
                        else -> {
                            val username = SharedPrefManager.getInstance(this).username
                            val tmpStr10: String = mCorrectAnswers.toString()

                            progressDialog = ProgressDialog(this@SignQuizGameQuestions13Shapes)
                            progressDialog!!.setMessage("Please wait....")
                            val stringRequest: StringRequest = object : StringRequest(
                                Method.POST, "https://deagtouch.000webhostapp.com/DeafTouch/InsertScore.php",
                                Response.Listener { response ->
                                    progressDialog!!.dismiss()
                                    try {


                                        val jsonObject = JSONObject(response)
                                        Toast.makeText(
                                            applicationContext,
                                            jsonObject.getString("message"),
                                            Toast.LENGTH_LONG
                                        )
                                        val intent = Intent(
                                            this@SignQuizGameQuestions13Shapes,
                                            SigQuizGameResult::class.java
                                        )
                                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                                        startActivity(intent)
                                        finish()
                                        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
                                    } catch (e: JSONException) {
                                        e.printStackTrace()
                                        Log.e("anyText", response!!)
                                    }
                                },
                                Response.ErrorListener { error ->
                                    Toast.makeText(
                                        applicationContext,
                                        error.message,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }) {
                                @Throws(AuthFailureError::class)
                                override fun getParams(): Map<String, String> {
                                    val params: MutableMap<String, String> = HashMap()
                                    params["username"] = username
                                    params["newscore"] = tmpStr10
                                    return params
                                }
                            }
                            val requestQueue = Volley.newRequestQueue(this)
                            requestQueue.add(stringRequest)
                        }
                    }

                } else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {

                        val imageView = findViewById<RelativeLayout>(R.id.wrongbtn)
                        imageView.visibility = View.VISIBLE

                        val mp = MediaPlayer.create(this, R.raw.wrongansweraudio3)
                        mp.start()
                        Handler().postDelayed(Runnable {
                            run {

                                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
                                imageView.visibility = View.GONE
                                mCorrectAnswers++

                            }
                        }, 2000)

                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)

                    } else {

                        val imageView = findViewById<RelativeLayout>(R.id.correctbtn)
                        imageView.visibility = View.VISIBLE

                        val mp = MediaPlayer.create(this, R.raw.correctansweraudio2)
                        mp.start()

                        Handler().postDelayed(Runnable {
                            run {

                                overridePendingTransition(R.anim.fadein, R.anim.fadeout)
                                imageView.visibility = View.GONE
                                mCorrectAnswers++

                            }
                        }, 2000)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        var btn_submit: Button
                        btn_submit = findViewById(R.id.btn_submit)
                        btn_submit.text = "FINISH"

                    } else {
                        var btn_submit: Button
                        btn_submit = findViewById(R.id.btn_submit)
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0

                }

            }

        }
    }

    private fun answerView(answer:Int, drawableView: Int ){

        var tv_option_one: TextView
        tv_option_one = findViewById(R.id.tv_option_one)

        var tv_option_two: TextView
        tv_option_two = findViewById(R.id.tv_option_two)

        var tv_option_three: TextView
        tv_option_three = findViewById(R.id.tv_option_three)

        var tv_option_four: TextView
        tv_option_four = findViewById(R.id.tv_option_four)

        when(answer){

            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                        this@SignQuizGameQuestions13Shapes,
                        drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                        this@SignQuizGameQuestions13Shapes,
                        drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                        this@SignQuizGameQuestions13Shapes,
                        drawableView
                )
            }
            4 -> {
                tv_option_four.background = ContextCompat.getDrawable(
                        this@SignQuizGameQuestions13Shapes,
                        drawableView
                )
            }
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this@SignQuizGameQuestions13Shapes,
                R.drawable.selected_option_border_bg
        )

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setMessage("Are You Sure Want To Quit This Game?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, which ->
                    startActivity(Intent(applicationContext, SignQuizGameSelectCategories::class.java))
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout)
                    finish()
                }
                .setNegativeButton("No", null)
                .show()
    }
}