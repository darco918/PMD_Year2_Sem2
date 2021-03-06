package com.example.fitnessappiadehackaton

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val intent =
                Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        login.setOnClickListener {
            val fragment = LogInFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentId, fragment, fragment.javaClass.simpleName)
                .commit()
            login.setTextColor(Color.parseColor("#35B9E5"))
            signUp.setTextColor(Color.parseColor("#ffffff"))
            nextButton.text = "Log in"
        }

        signUp.setOnClickListener {
            val fragment = SignUpFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentId, fragment, fragment.javaClass.simpleName)
                .commit()
            signUp.setTextColor(Color.parseColor("#35B9E5"))
            login.setTextColor(Color.parseColor("#ffffff"))
            nextButton.text = "Sign up"

        }

        nextButton.translationZ = 90f


        }

    }