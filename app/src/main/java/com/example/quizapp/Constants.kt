package com.example.quizapp

object Constants {

    const val USER_NAME:String="user_name"
    const val TOTAL:String="total"
    const val ANSWER:String="answer"

    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()
        val que1=Question(
            1,
            "Hangi ülkenin bayrağı?",
            R.drawable.turkiye,
            "Turkiye",
            "Yunanistan",
            "Almanya",
            "Fransa",
            1)
        questionsList.add(que1)

        val que2=Question(
            2,
            "Hangi ülkenin bayrağı?",
            R.drawable.almanya,
            "Turkiye",
            "Rusya",
            "Almanya",
            "Romanya",
            3)
        questionsList.add(que2)

        val que3=Question(
            3,
            "Hangi ülkenin bayrağı?",
            R.drawable.hollanda,
            "italya",
            "Slovenya",
            "Almanya",
            "Hollanda",
            4)
        questionsList.add(que3)

        val que4=Question(
            4,
            "Hangi ülkenin bayrağı?",
            R.drawable.estonya,
            "Estonya",
            "İspanya",
            "Slovakya",
            "BosnaHersek",
            1)
        questionsList.add(que4)

        val que5=Question(
            5,
            "Hangi ülkenin bayrağı?",
            R.drawable.bosnahersek,
            "BosnaHersek",
            "Yunanistan",
            "Almanya",
            "Fransa",
            1)
        questionsList.add(que5)
        return questionsList
    }
}