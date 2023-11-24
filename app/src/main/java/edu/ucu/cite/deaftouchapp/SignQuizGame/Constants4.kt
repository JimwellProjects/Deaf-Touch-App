package edu.ucu.cite.deaftouchapp

object Constants4 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.emotiosn_happy,
                "Happy", "Bored",
                "Excited", "Shy", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.emotiosn_excited,
                "Angry", "Cheeky",
                "Excited", "Contented", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.emotiosn_surprised,
                "Depressed", "Calm",
                "Relax", "Surprised", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.emotiosn_relax,
                "Sneaky", "Relax",
                "Sleepy", "Stressed", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.emotiosn_calm,
                "Tense", "Upset",
                "Calm", "Nervous", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.emotiosn_bored,
                "Bored", "Relax",
                "Angry", "Frightened", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.emotiosn_angry,
                "Excited", "Disgust",
                "Angry", "Cheeky", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.emotiosn_nervous,
                "Sad", "Upset",
                "Surprised", "Nervous", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.emotiosn_shy,
                "Shy", "Shy",
                "Happy", "Contented", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.emotiosn_sleepy,
                "Sleepy", "Disgust",
                "Cheeky", "Excited", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}