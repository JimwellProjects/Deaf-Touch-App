package edu.ucu.cite.deaftouchapp

object Constants6 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.animals_zibra,
                "Dog", "Snake",
                "Zibra", "Wolf", 3
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.animals_aligator,
                "Alligator", "Bear",
                "Bird", "Cow", 1
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.animals_snake,
                "Wolf", "Snake",
                "Rat", "Lion", 2
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.animals_cow,
                "Alligator", "Cow",
                "Frog", "Lion", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.animals_giraffe,
                "Giraffe", "Lion",
                "Rat", "Tiger", 1
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.animals_bear,
                "Duck", "Elephant",
                "Fish", "Bear", 4
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.animals_owl,
                "Owl", "Pig",
                "Rat", "Tiger", 1
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.animals_duck,
                "Fish", "Duck",
                "Frog", "OWl", 2
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.animals_tiger,
                "Zibra", "Mouse",
                "Pig", "Tiger", 4
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.animals_fish,
                "Lion", "Snake",
                "Fish", "Bird", 3
        )

        questionsList.add(que10)

        return questionsList
    }
}