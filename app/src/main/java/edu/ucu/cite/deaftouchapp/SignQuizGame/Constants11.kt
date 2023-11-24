package edu.ucu.cite.deaftouchapp

import edu.ucu.cite.deaftouchapp.Question
import edu.ucu.cite.deaftouchapp.R

object Constants11 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.bodyparts_neck,
                "Nose", "Head",
                "Neck", "Heart", 3
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.bodyparts_face,
                "Face", "Arm",
                "Head", "Nose", 1
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.bodyparts_ear,
                "Foot", "Ear",
                "Face", "Hands", 2
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.bodyparts_heart,
                "Mouse", "Stomach",
                "Nose", "Heart", 4
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.bodyparts_eyes,
                "Eyes", "Hands",
                "Head", "Neck", 1
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.bodyparts_arm,
                "Body", "Back",
                "Arm", "Eyes", 3
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.bodyparts_stomach,
                "Hair", "Foot",
                "Stomach", "Bald", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.bodyparts_mouth,
                "Head", "Mouth",
                "Face", "Heart", 2
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.bodyparts_nose,
                "Back", "Eyes",
                "Foot", "Nose", 4
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.bodyparts_body,
                "Body", "Face",
                "Arm", "Neck", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}