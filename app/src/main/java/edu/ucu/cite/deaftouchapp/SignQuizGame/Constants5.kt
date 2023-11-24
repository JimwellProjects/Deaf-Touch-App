package edu.ucu.cite.deaftouchapp

import edu.ucu.cite.deaftouchapp.Question
import edu.ucu.cite.deaftouchapp.R

object Constants5 {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.colors_brown,
                "Black", "Brown",
                "Green", "Red", 2
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.colors_purple,
                "Tan", "Yellow",
                "Purple", "Gold", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.colors_green,
                "Orange", "Red",
                "Green", "Purple", 3
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.colors_black,
                "Gold", "Green",
                "Red", "Black", 4
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.colors_orange,
                "Black", "Orange",
                "Brown", "Purple", 2
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.colors_blue,
                "Blue", "Yellow",
                "Tan", "Green", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.colors_yellow,
                "Yellow", "Orange",
                "Red", "Brown", 1
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.colors_tan,
                "Purple", "Gold",
                "Tan", "Red", 3
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.colors_gold,
                "Purple", "Gold",
                "Black", "Orange", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.colors_red,
                "Orange", "Green",
                "Brown", "Red", 4
        )

        questionsList.add(que10)

        return questionsList
    }

}