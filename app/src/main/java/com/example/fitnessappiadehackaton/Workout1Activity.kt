package com.example.fitnessappiadehackaton

import android.graphics.Color.rgb
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_workout1.*

class Workout1Activity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout1)

        startSets()

        view_timer.isCountDown = false

        view_timer.start()



        view_timer.setOnChronometerTickListener {
            if (view_timer.base == SystemClock.elapsedRealtime()){
                view_timer.stop()
                view_timer.base = SystemClock.elapsedRealtime() + 5000
                view_timer.isCountDown = false
            }
            Log.d("",view_timer.base.toString())
        }
    }

    private fun startSets() {
        val squatArray = arrayOf(set1,set2,set3,set4,set5,set6)
        val benchArray = arrayOf(bench1,bench2,bench3,bench4,bench5,bench6)
        val deadliftArray = arrayOf(dead1,dead2,dead3,dead4,dead5,dead6)


        for ( i in squatArray){
            i.setOnClickListener {
                setClick(i)
            }
        }

        for ( i in benchArray){
            i.setOnClickListener {
                setClick(i)
            }
        }

        for ( i in deadliftArray){
            i.setOnClickListener {
                setClick(i)
            }
        }
    }
    private fun setClick(set: Button){
        set.setTextColor(rgb(255,255,255))
        var i = 0
        if(set.text.toString() == "0"){
            i = 7
        }
        else{
            i = set.text.toString().toInt()
        }
        activateSet(set,i-1)
    }

    private fun activateSet(set:Button, i : Int){
        set.setBackgroundResource(R.drawable.round_button)

        if(i == 0) {set.text = "0"
            set.setBackgroundResource(R.drawable.round_inactive_button)
            set.setTextColor(rgb(255,0,0))

        }
        else         set.text = i.toString()

        if(i == 6)   set.setTextColor(rgb(0,255,0))

    }
}