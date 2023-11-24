package edu.ucu.cite.deaftouchapp

object Constants3 {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.greetings_hello,
                "Hello", "How Are You",
                "Good Day", "Good Morning", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.greetings_goodtoseeyou,
                "How Are You", "How Is It Going",
                "Good To See You", "Good Day", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.greetings_goodmorning,
                "Good Afternoon", "Good Day",
                "Good Bye", "Good Morning", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.greetings_goodevening,
                "Hello", "Good Evening",
                "Good Morning", "How Are You", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.greetings_goodafternoon,
                "Good Evening", "How Is It Going",
                "Good Afternoon", "How Are You", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.greetings_goodbye,
                "Good Bye", "Good Afternoon",
                "Hello", "Good To See You", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.greetings_howareyou,
                "Good Day", "Good Morning",
                "How Are You", "Good To See You", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.greetings_howisitgoing,
                "How Are You", "Hello",
                "Good Evening", "How Is It Going", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.greetings_goodday,
                "Good Bye", "Good Day",
                "Good Morning", "Good To See You", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.greetings_hello,
                "Hello", "How Are Yiy",
                "How Is It Going", "Good Afternoon", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}