package edu.ucu.cite.deaftouchapp

object Constants8 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.ewd_cooking,
                "Cooking", "Clean",
                "Wait", "Watching", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.ewd_wash,
                "Sleep", "Wash",
                "Walk", "Wait", 2
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.ewd_push,
                "Reading", "Push",
                "Sit", "Sleep", 2
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.ewd_laugh,
                "Look", "Fall Down",
                "Give", "Laugh", 4
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.ewd_eat,
                "Wait", "Reading",
                "Eat", "Wash", 2
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.ewd_reading,
                "Reading", "Swim",
                "Run", "Walk", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.ewd_sleep,
                "Run", "Walk",
                "Sleep", "Sit", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.ewd_cry,
                "Sad", "Cry",
                "Eat", "Give", 2
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.ewd_look,
                "Clean", "CLimb",
                "Look", "Eat", 3
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.ewd_climb,
                "Climb", "Laugh",
                "Swim", "Drink", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}