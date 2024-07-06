package com.example.quizapp

import android.app.SearchManager.OnCancelListener
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionsBinding
    private var mCurrentPosition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private  var mUserNAme:String?=null
    private var mCorrectAnswers:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        mUserNAme=intent.getStringExtra(Constants.USER_NAME)


        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
        mQuestionsList = Constants.getQuestions()
        setQuestion()


    }

    private fun setQuestion() {
        defulOptionsView()

        val question: Question =  mQuestionsList!![mCurrentPosition - 1]
        binding.imageView.setImageResource(question.image)
        binding.progressBar.progress = mCurrentPosition
        binding.textProgress.text = "${mCurrentPosition}/${binding.progressBar.max}"
        binding.tvQuestion.text = question.questions
        binding.optionOne.text = question.optionOne
        binding.optionTwo.text = question.optionTwo
        binding.optionThree.text = question.optionThree
        binding.optionFour.text = question.optionFour

        if (mCurrentPosition==mQuestionsList!!.size){
            binding.btnSubmit.text="Fınısh"
        }else{
            binding.btnSubmit.text="Submit"
        }
    }

    private fun defulOptionsView(){
        val options=ArrayList<TextView>()
        binding.optionOne.let {
            options.add(0,it)
        }
        binding.optionTwo.let {
            options.add(1,it)
        }
        binding.optionThree.let {
            options.add(2,it)
        }
        binding.optionFour.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this@QuizQuestionsActivity,R.drawable.osmannn)

        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defulOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#FF0000"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this@QuizQuestionsActivity,R.drawable.osmannn)

    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one->{
                binding.optionOne.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.option_two->{
                binding.optionTwo.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.option_three->{
                binding.optionThree.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.option_four->{
                binding.optionFour.let {
                    selectedOptionView(it,4)
                }
            }
           R.id.btn_Submit->{
               if(mSelectedOptionPosition==0){
                   mCurrentPosition++

                   when{
                       mCurrentPosition<=mQuestionsList!!.size ->{ setQuestion() }
                       else->{
                           val intent= Intent(
                               this@QuizQuestionsActivity,
                               FinishActivity::class.java)
                           intent.putExtra(Constants.USER_NAME,mUserNAme)
                           intent.putExtra(Constants.ANSWER,mCorrectAnswers)
                           intent.putExtra(Constants.TOTAL,mQuestionsList?.size)
                           startActivity(intent)
                           finish()
                       }
                   }
               }else{
                   val question=mQuestionsList?.get(mCurrentPosition-1)
                   if (question!!.correctAnswer!=mSelectedOptionPosition){
                       answerView(mSelectedOptionPosition,R.drawable.greenandred)
                   }else{
                        mCorrectAnswers++
                   }
                   answerView(question.correctAnswer,R.drawable.redandgreen)

                   if(mCurrentPosition==mQuestionsList!!.size){
                       binding.btnSubmit.text="Fınısh"
                   }else{
                       binding.btnSubmit.text="Go to next question"
                   }
                   mSelectedOptionPosition=0
               }
           }
        }

    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{binding.optionOne.background=ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)}
            2->{binding.optionTwo.background=ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)}
            3->{binding.optionThree.background=ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)}
            4->{binding.optionFour.background=ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)}
        }

    }
}