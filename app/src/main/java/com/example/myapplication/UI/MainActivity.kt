package com.example.myapplication.UI

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import com.example.haircare.R
import com.example.haircare.fragments.Signup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//test
    var manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        ShowSignupPage()
        ShowLoginPage()

        share_photo.setOnClickListener {
            val imageUri = Uri.parse("android.resource://" + packageName
                    + "/drawable/" + "haircutone")
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT,
                "Hello! my name is micaiah i am a stylist " +
                    "based in New York above is some of my haircuts! " +
                    "if you want to see more please check me out at www.hairstyles.com/micaiah")
            shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
            shareIntent.type = "image/jpeg"
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(Intent.createChooser(shareIntent, "send"))


        }
    }




    fun ShowSignupPage() {
        val transaction = manager.beginTransaction()
        val frg_signup = Signup()
        transaction.addToBackStack(null)
        transaction.commit()


        // Set a click listener for button
        signup_button.setOnClickListener {

            // Initialize a new layout inflater instance
            val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            // Inflate a custom view using layout inflater
            val view = inflater.inflate(R.layout.sign_up_window, null)

            // Initialize a new popup window
            val signUpWindow = PopupWindow (
                view, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,true


            )
            // Set an elevation for the popup window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                signUpWindow.elevation = 10.0F

            }
            // If API level 23 or higher then execute the code
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                // Create a new slide animation for the pop up window
                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                signUpWindow.enterTransition = slideIn


                val slideOut = Slide()
                slideOut.slideEdge = Gravity.RIGHT
                signUpWindow.exitTransition = slideOut

            }


            val signUpButton = view.findViewById<Button>(R.id.btn_sign_up)

            // Set a click listener to dismess the window
            signUpButton.setOnClickListener {
               // val context = this
                //var intent = Intent(context,Ha)
                val context = this
                val intent = Intent(context,recyclertest::class.java)
                startActivity(intent)
                finish()

                signUpWindow.dismiss()

            }

            // Show the window on the app and the location to display the window
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
                view, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,true


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
                val context = this
                val profileIntent = Intent(context,Profile_2_Activity::class.java)
                startActivity(profileIntent)
                finish()
                loginWindow.dismiss()

            }

            TransitionManager.beginDelayedTransition(main_layout)
            loginWindow.showAtLocation(
                main_layout, Gravity.CENTER,0,0
            )




        }

    }

}


