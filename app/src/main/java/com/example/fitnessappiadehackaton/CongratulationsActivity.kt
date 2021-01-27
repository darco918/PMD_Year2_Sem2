package com.example.fitnessappiadehackaton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_congratulations.*

class CongratulationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulations)

        backButton.setOnClickListener {
            back()
        }
    }
    override fun onBackPressed() {
        back()
    }
    private fun back(){
        startActivity(Intent(this,MainActivity::class.java))
    }
}