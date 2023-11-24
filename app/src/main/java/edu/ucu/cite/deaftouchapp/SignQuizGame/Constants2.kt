package edu.ucu.cite.deaftouchapp

object Constants2 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.number_one,
                "1", "5",
                "3", "8", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.number_two,
                "6", "8",
                "2", "4", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.number_three,
                "5", "9",
                "7", "3", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.number_four,
                "6", "4",
                "8", "10", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.number_five,
                "9", "10",
                "5", "2", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.number_six,
                "6", "7",
                "10", "4", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.number_seven,
                "3", "9",
                "7", "8", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.number_eight,
                "1", "6",
                "10", "8", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.number_nine,
                "7", "9",
                "3", "10", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.number_ten,
                "10", "13",
                "19", "16", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}