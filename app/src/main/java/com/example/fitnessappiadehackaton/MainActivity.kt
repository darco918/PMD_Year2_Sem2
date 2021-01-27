package com.example.fitnessappiadehackaton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_bar.selectTabAt(1, true)

        bottom_bar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                    lastIndex: Int,
                    lastTab: AnimatedBottomBar.Tab?,
                    newIndex: Int,
                    newTab: AnimatedBottomBar.Tab
            ) {
                if( newIndex == 0) {
                    val fragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .add(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
                        .commit()
                }
                else if( newIndex == 1) {
                    val fragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .add(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
                        .commit()
                }
                else{
                    val fragment = CalendarFragment()
                    supportFragmentManager.beginTransaction()
                        .add(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
                        .commit()
                }            }

            // An optional method that will be fired whenever an already selected tab has been selected again.
            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
                Log.d("bottom_bar", "Reselected index: $index, title: ${tab.title}")
                if( index == 0) {
                    val fragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
                        .commit()
                }
                else if( index == 1) {
                    val fragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
                        .commit()
                }
                else{
                    val fragment = CalendarFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, fragment, fragment.javaClass.simpleName)
                        .commit()
                }
            }

        })
    }
}