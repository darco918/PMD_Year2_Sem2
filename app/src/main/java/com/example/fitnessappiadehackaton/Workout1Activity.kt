package com.example.fitnessappiadehackaton

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Color.rgb
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_workout1.*
import java.lang.reflect.Field

class Workout1Activity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    private lateinit var timer: CountDownTimer


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout1)
        bottomTextTv.text = "Sweat the COVID out!"
        val countDownText = findViewById<TextView>(R.id.countdown)
        startSets(countDownText)
        setUpSpinners()
        startCounter(180,countDownText)
    }

    private fun startSets(countDownText:TextView) {
        val squatArray = arrayOf(set1,set2,set3,set4,set5,set6)
        val benchArray = arrayOf(bench1,bench2,bench3,bench4,bench5,bench6)
        val deadliftArray = arrayOf(dead1,dead2,dead3,dead4,dead5,dead6)

        for ( i in squatArray){
            i.setOnClickListener {
                setClick(i,countDownText)
            }
        }

        for ( i in benchArray){
            i.setOnClickListener {
                setClick(i,countDownText)
            }
        }

        for ( i in deadliftArray){
            i.setOnClickListener {
                setClick(i,countDownText)
            }
        }
    }

    private fun setClick(set: Button,countDownText:TextView){
        set.setTextColor(rgb(255,255,255))
        var i = 0
        if(set.text.toString() == "0"){
            i = 7
        }
        else{
            i = set.text.toString().toInt()
        }
        activateSet(set,i-1, countDownText)
    }

    @SuppressLint("SetTextI18n")
    private fun activateSet(set:Button, i : Int, countDownText:TextView){
        set.setBackgroundResource(R.drawable.round_button)
        if(i == 0) {set.text = "0"
            set.setBackgroundResource(R.drawable.round_inactive_button)
            set.setTextColor(rgb(255,0,0))
        }
        else         set.text = i.toString()
        if(i == 6)   set.setTextColor(rgb(0,255,0))
        bottomTextTv.text = "Congrats on finishing 5 reps! Rest 90sec if it was easy or 180sec if hard!"
        timer.cancel()
        startCounter(180,countDownText)
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
               // Toast.makeText(this@Workout1Activity, "$item selected",Toast.LENGTH_SHORT).show()
            }
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
              //  Toast.makeText(this@Workout1Activity, "$item selected",Toast.LENGTH_SHORT).show()
                }
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
             //   Toast.makeText(this@Workout1Activity, "$item selected",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun  vibrate(){
        val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(1000,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            v.vibrate(1000)
        }
    }

    private fun startCounter(mCounter:Int, countDownText:TextView){
       var counter = mCounter
       timer= object : CountDownTimer((counter*1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countDownText.text = counter.toString()
                progressBar.progress =(100- (counter * 5)/9)
                counter--
                if((counter == 90) or (counter == 25)){
                    countDownText.setTextColor(Color.parseColor("#FF0000"))
                    vibrate()
                }
            }
            override fun onFinish() {
                counter = 180
                countDownText.setTextColor(Color.parseColor("#ffffff"))
                vibrate()
            }
        }.start()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        timer.cancel()
    }
}