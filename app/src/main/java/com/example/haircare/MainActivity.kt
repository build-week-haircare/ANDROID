package com.example.haircare

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sign_up_window.*

class MainActivity : AppCompatActivity() {

    var manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ShowSignupPage()
    }




    fun ShowSignupPage() {
        val transaction = manager.beginTransaction()
        val frg_signup = Signup()
        transaction.replace(R.id.fragment_holder,frg_signup)
        transaction.addToBackStack(null)
        transaction.commit()


        btn_create_acc.setOnClickListener {

            val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


            val view = inflater.inflate(R.layout.sign_up_window, null)

            val signUpWindow = PopupWindow (
                view, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT

            )

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                signUpWindow.elevation = 10.0F

            }
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                signUpWindow.enterTransition = slideIn


                val slideOut = Slide()
                slideOut.slideEdge = Gravity.RIGHT
                signUpWindow.exitTransition = slideOut

            }

            val signUpButton = view.findViewById<Button>(R.id.btn_sign_up)
            signUpButton.setOnClickListener {
                signUpWindow.dismiss()

            }

            TransitionManager.beginDelayedTransition(main_layout)
            signUpWindow.showAtLocation(
                main_layout, Gravity.CENTER,0,0
            )




        }

    }


}
