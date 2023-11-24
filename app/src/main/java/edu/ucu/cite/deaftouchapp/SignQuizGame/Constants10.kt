package edu.ucu.cite.deaftouchapp

import edu.ucu.cite.deaftouchapp.Question
import edu.ucu.cite.deaftouchapp.R

object Constants10 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.questions_howareyou,
                "Ok", "How Are You",
                "What", "How", 2
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.questions_where,
                "Where", "Ok",
                "Who", "When", 1
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.questions_youok,
                "Whats Up", "What To Do",
                "You Ok", "When", 3
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.questions_whoisthat,
                "How Many", "How Much",
                "What To Do", "Who Is That", 4
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.questions_whereyoufrom,
                "Where You From", "You Ok",
                "Why", "Which", 1
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.questions_whatdo,
                "When", "What To Do",
                "How", "Where", 3
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.questions_howmany,
                "Where", "Who Is That",
                "How Many", "Whats Up", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.questions_howmuch,
                "How Much", "How",
                "What Kind", "Which", 1
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.questions_what,
                "What", "How",
                "Where", "Which", 1
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.questions_where,
                "Which", "Where",
                "Why", "Who", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}