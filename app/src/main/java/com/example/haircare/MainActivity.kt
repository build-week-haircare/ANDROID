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
import com.example.haircare.fragments.Signup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ShowSignupPage()
        ShowLoginPage()
    }




    fun ShowSignupPage() {
        val transaction = manager.beginTransaction()
        val frg_signup = Signup()
        transaction.addToBackStack(null)
        transaction.commit()


        signup_button.setOnClickListener {


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


    fun ShowLoginPage() {


        val transaction = manager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.commit()


        stylist_button.setOnClickListener {


            val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


            val view = inflater.inflate(R.layout.login_window, null)

            val loginWindow = PopupWindow (
                view, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT


            )

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                loginWindow.elevation = 10.0F

            }
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                val slideIn = Slide()
                slideIn.slideEdge = Gravity.RIGHT
                loginWindow.enterTransition = slideIn


                val slideOut = Slide()
                slideOut.slideEdge = Gravity.BOTTOM
                loginWindow.exitTransition = slideOut

            }

            val loginButton = view.findViewById<Button>(R.id.btn_login_popup)
            loginButton.setOnClickListener {
                loginWindow.dismiss()

            }

            TransitionManager.beginDelayedTransition(main_layout)
            loginWindow.showAtLocation(
                main_layout, Gravity.CENTER,0,0
            )




        }

    }

}


