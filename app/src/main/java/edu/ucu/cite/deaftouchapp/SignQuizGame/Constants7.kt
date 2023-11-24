package edu.ucu.cite.deaftouchapp

object Constants7 {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
                1, "What Sign Is This?",
                R.drawable.foods_chicken,
                "Egg", "Chicken",
                "Hotdog", "Coffee", 2
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
                2, "What Sign Is This?",
                R.drawable.foods_milk,
            "Soda Pop", "Meat",
            "Milk", "Pizza", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
                3, "What Sign Is This?",
                R.drawable.foods_fruit,
            "Meat", "Fruit",
            "Pizza", "Ice Cream", 2


        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
                4, "What Sign Is This?",
                R.drawable.foods_icecream,
                "Soda Pop", "Ice Cream",
                "Milk", "Fruit", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
                5, "What Sign Is This?",
                R.drawable.foods_hamburger,
                "Bread", "Cereal",
                "Hamburger", "Egg", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
                6, "What Sign Is This?",
                R.drawable.foods_soda_pop,
                "Soda Pop", "Meat",
                "Milk", "pizza", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
                7, "What Sign Is This?",
                R.drawable.foods_chocolate,
                "Meat", "Cake",
                "Cereal", "Chocolate", 4
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
                8, "What Sign Is This?",
                R.drawable.foods_french_fries,
                "French Fries", "Salad",
                "Vegetable", "Candy", 1
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
                9, "What Sign Is This?",
                R.drawable.foods_candy,
                "Cereal", "Cake",
                "Candy", "Sandwich", 3
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
                10, "What Sign Is This?",
                R.drawable.foods_hotdog,
                "Vegetable", "Hotdog",
                "Coffee", "Chicken", 2
        )

        questionsList.add(que10)

        return questionsList
    }
}