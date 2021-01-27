package com.example.fitnessappiadehackaton

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_study1.*
import kotlinx.android.synthetic.main.activity_study1.bottomTextTv

class StudyActivity1 : AppCompatActivity() {
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study1)

        val countDownText = findViewById<TextView>(R.id.countDownStudy2)
        tvFirstTask.text = intent.getStringExtra("firstExercise")
        tvSecondTask.text = intent.getStringExtra("secondExercise")

        startCounter(30, countDownText,0)
        startSets(countDownText)
        finishButtonStudy.setOnClickListener {
            finishWorkout()
        }
    }

    private fun startSets(countDownText: TextView) {
        val firstExArray = arrayOf(first1, first2, first3, first4)
        val secondExArray = arrayOf(second1, second2, second3, second4)
        var position=0 // get position of i in array
        for (i in firstExArray) {
            i.setOnClickListener {
                setClick(i, countDownText,position)
            }
            position++
        }
        position=0
        for (i in secondExArray) {
            i.setOnClickListener {
                setClick(i, countDownText,position)
            }
            position++
        }
    }

    private fun setClick(set: Button, countDownText: TextView,position:Int) {
        set.setTextColor(Color.rgb(255, 255, 255))
        var i = 1
        if (set.text.toString() == "0") {
            i = 2
        } else {
            i = set.text.toString().toInt()
        }
        activateSet(set, i - 1, countDownText,position)
    }

    @SuppressLint("SetTextI18n")
    private fun activateSet(set: Button, i: Int, countDownText: TextView,position:Int) {
        set.setBackgroundResource(R.drawable.round_button)
        if (i == 0) {
            set.text = "0"
            set.setBackgroundResource(R.drawable.round_inactive_button)
        } else set.text = "1"
        bottomTextTv.text =
            "Every minute counts! Exams are coming!"
        timer.cancel()

        if((position == 0) or (position == 2)){
            startCounter(30*60, countDownText,position)
        }
        else{
            startCounter(30*60, countDownText,position)

        }

    }


    private fun vibrate() {
        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(
                VibrationEffect.createOneShot(
                    1000,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        } else {
            v.vibrate(1000)
        }
    }

    private fun startCounter(mCounter: Int, countDownText: TextView,position:Int) {
        var counter = mCounter
        timer = object : CountDownTimer((counter*1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countDownText.text = (counter/60).toString()
                if((position== 0) or (position == 2))
                    progressBarStudy.progress = (100 - (counter * 5) / 6)
                else
                    progressBarStudy.progress = (100 - (counter * 10) )

                counter--
//                if ((counter == 90) or (counter == 25)) {
//                    countDownText.setTextColor(Color.parseColor("#FF0000"))
//                    vibrate()
//                }
            }

            override fun onFinish() {
                counter = 10*60
                countDownText.setTextColor(Color.parseColor("#ffffff"))
                vibrate()
            }
        }.start()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        timer.cancel()
    }

    private fun finishWorkout() {
        //What happens when you finish the workout
        timer.cancel()
        //don't forget to save the workout details in shared preferences
        val intent = Intent(this, CongratulationsActivity::class.java)
        startActivity(intent)
    }
}