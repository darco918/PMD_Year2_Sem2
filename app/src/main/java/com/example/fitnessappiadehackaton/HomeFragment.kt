package com.example.fitnessappiadehackaton

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.fragment_home.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


private var clicked: Boolean = false
/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_btn.setOnClickListener {
            if (!clicked){
                view.edit_btn.visibility = View.VISIBLE
                add_btn.visibility = View.VISIBLE
            }else
            {
                edit_btn.visibility = View.INVISIBLE
                add_btn.visibility = View.INVISIBLE
            }
            addClicked()
        }
        edit_btn.setOnClickListener {
            val intent = Intent (activity, Workout1Activity::class.java)
            startActivity(intent)        }
        finger_btn.setOnClickListener {
            Toast.makeText(activity, "Finger button Clicked!", Toast.LENGTH_SHORT).show()
        }

    }
        companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun addClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked : Boolean) {
        val rotateOpen:Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_open) }
        val rotateClose:Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.rotate_close) }
        val toBottom:Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.to_bottom) }
        val fromBottom:Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.from_bottom) }
        if (!clicked){

            edit_btn.startAnimation(fromBottom)
            finger_btn.startAnimation(fromBottom)
            add_btn.startAnimation(rotateOpen)
        }
        else{
            edit_btn.startAnimation(toBottom)
            finger_btn.startAnimation(toBottom)
            add_btn.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked : Boolean) {

    }

    private fun setClickable(clicked: Boolean){
        if (!clicked){
            edit_btn.isClickable = true
            finger_btn.isClickable = true
        }else{
            edit_btn.isClickable = false
            finger_btn.isClickable = false
        }
    }
}