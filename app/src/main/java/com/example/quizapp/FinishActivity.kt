package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityFinishBinding

class FinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.name.text=intent.getStringExtra(Constants.USER_NAME)

        val totalScore=intent.getIntExtra(Constants.TOTAL,0)
        val answer=intent.getIntExtra(Constants.ANSWER,0)

        binding.score.text="Skorunuz=$answer / $totalScore"

        binding.egain.setOnClickListener {
            val intent= Intent(
                this@FinishActivity,
                MainActivity::class.java)
             startActivity(intent)
        }
    }

}