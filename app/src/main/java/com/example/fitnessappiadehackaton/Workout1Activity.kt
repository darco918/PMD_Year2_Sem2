package com.example.fitnessappiadehackaton

import android.graphics.Color.rgb
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_workout1.*
import java.lang.reflect.Field

class Workout1Activity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout1)

        startSets()
        setUpSpinners()
        view_timer.isCountDown = false

        view_timer.start()



        view_timer.setOnChronometerTickListener {
            if(view_timer.text == "00:05")
                set1.setBackgroundResource(R.drawable.round_button)

          //  progressBar.progress =

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

    private fun setUpSpinners(){
        val list:MutableList<String> = ArrayList()
        for (i:Int in 20..170 step 5){
            list.add("6x6 $i Kg")
        }

        val adapter = ArrayAdapter(this, R.layout.spinner_text, list)
        spnSquat.adapter = adapter
        spnSquat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item: String = list[position]
                Toast.makeText(this@Workout1Activity, "$item selected",Toast.LENGTH_SHORT).show()}
        }

        spnBench.adapter = adapter
        spnBench.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item: String = list[position]
                Toast.makeText(this@Workout1Activity, "$item selected",Toast.LENGTH_SHORT).show()}
        }

        spnDead.adapter = adapter
        spnDead.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item: String = list[position]
                Toast.makeText(this@Workout1Activity, "$item selected",Toast.LENGTH_SHORT).show()}
        }

    }

}