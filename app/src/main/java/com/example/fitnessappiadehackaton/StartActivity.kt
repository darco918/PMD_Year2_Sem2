package com.example.fitnessappiadehackaton

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_start.*
import kotlinx.android.synthetic.main.activity_workout1.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        var counter = 2
        val timer= object : CountDownTimer((counter*1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                counter--
            }
            override fun onFinish() {
                startActivity(Intent(this@StartActivity, LogInActivity::class.java))
            }
        }.start()

    }
}