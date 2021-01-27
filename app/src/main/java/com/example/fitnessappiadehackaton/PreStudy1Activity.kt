package com.example.fitnessappiadehackaton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pre_study1.*

class PreStudy1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_study1)
        startButton.setOnClickListener {
            val intent = Intent(this, StudyActivity1::class.java)
            intent.putExtra("firstExercise", firstExerciseEditText.text.toString())
            intent.putExtra("secondExercise", secondExerciseEditText.text.toString())
            startActivity(intent)
        }
    }
}