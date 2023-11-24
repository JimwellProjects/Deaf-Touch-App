package edu.ucu.cite.deaftouchapp

object Constants9 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.months_december,
                "January", "February",
                "December", "June", 3
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.months_july,
                "October", "July",
                "September", "December", 2
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.months_june,
                "August", "March",
                "June", "November", 3
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.months_january,
                "May", "July",
                "October", "January", 4
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.months_february,
                "February", "April",
                "August", "September", 1
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.months_april,
                "February", "May",
                "August", "April", 4
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.months_march,
                "October", "November",
                "March", "January", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.months_september,
                "September", "June",
                "March", "July", 1
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.months_november,
                "March", "November",
                "January", "June", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.months_august,
                "September", "May",
                "March", "August", 4
        )

        questionsList.add(que10)

        return questionsList
    }
}