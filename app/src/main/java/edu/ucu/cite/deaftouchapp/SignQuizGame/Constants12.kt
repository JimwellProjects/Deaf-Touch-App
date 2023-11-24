package edu.ucu.cite.deaftouchapp

import edu.ucu.cite.deaftouchapp.Question
import edu.ucu.cite.deaftouchapp.R

object Constants12 {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.familymembers_cousin,
                "Dad", "Cousin",
                "Kid", "Nephew", 3
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.familymembers_mom,
                "Family", "Niece",
                "Mom", "Son", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.familymembers_dad,
                "Dad", "Son",
                "Uncle", "Brother", 1
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.familymembers_sister,
                "Sister", "Mom",
                "Niece", "Auntie", 1
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.familymembers_grandfather,
                "Kid", "Family",
                "Cousin", "Grandfather", 4
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.familymembers_grandma,
                "Uncle", "GrandMa",
                "Dad", "Nephew", 3
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.familymembers_brother,
                "Brother", "Niece",
                "Cousin", "Auntie", 1
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.familymembers_family,
                "Son", "Dad",
                "Family", "Brother", 3
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.familymembers_auntie,
                "Niece", "Auntie",
                "Nephew", "Sister", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.familymembers_cousin,
                "Cousin", "Family",
                "Dad", "Kid", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}