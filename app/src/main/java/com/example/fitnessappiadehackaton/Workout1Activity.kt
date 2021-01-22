package com.example.fitnessappiadehackaton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_workout1.*

class Workout1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout1)

        set1.setOnClickListener {
            var i = 0
            if(set1.text.toString() == "0"){
                i = 7
            }
            else{
                i = set1.text.toString().toInt()
            }
            activateSet(set1,i-1)
        }

        set2.setOnClickListener {
            var i = 0
            if(set2.text.toString() == "0"){
                i = 7
            }
            else{
                i = set2.text.toString().toInt()
            }
            activateSet(set2,i-1)
        }

        set3.setOnClickListener {
            var i = 0
            if(set3.text.toString() == "0"){
                i = 7
            }
            else{
                i = set3.text.toString().toInt()
            }
            activateSet(set3,i-1)
        }

        set4.setOnClickListener {
            var i = 0
            if(set4.text.toString() == "0"){
                i = 7
            }
            else{
                i = set4.text.toString().toInt()
            }
            activateSet(set4,i-1)
        }

        set5.setOnClickListener {
            var i = 0
            if(set5.text.toString() == "0"){
                i = 7
            }
            else{
                i = set5.text.toString().toInt()
            }
            activateSet(set5,i-1)
        }

        set6.setOnClickListener {
            var i = 0
            if(set6.text.toString() == "0"){
                i = 7
            }
            else{
                i = set6.text.toString().toInt()
            }
            activateSet(set6,i-1)
        }
    }

    private fun activateSet(set:Button, i : Int){
        set.setBackgroundResource(R.drawable.round_button)
        if(i == 0) {set.text = "0"
            set.setBackgroundResource(R.drawable.round_inactive_button)

        }
        else         set.text = i.toString()



    }
}