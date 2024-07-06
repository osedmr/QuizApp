package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnStart.setOnClickListener {
            if(binding.name.text?.isNotEmpty() == false){
                Toast.makeText(this@MainActivity,"Lütfen isim giriniz",Toast.LENGTH_LONG).show()
            }else{

                val intent=Intent(this@MainActivity,QuizQuestionsActivity::class.java)

                intent.putExtra(Constants.USER_NAME,binding.name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}