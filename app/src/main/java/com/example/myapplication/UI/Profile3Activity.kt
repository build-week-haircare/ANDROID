package com.example.myapplication.UI

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.haircare.R
import com.example.haircare.fragments.*
import kotlinx.android.synthetic.main.activity_profile_3_.*

class Profile3Activity : AppCompatActivity() {
    var isBioLoaded = true
    var isWorksLoaded = false
    var isReviewsLoaded = false
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_3_)

        val works = findViewById<Button>(R.id.btn_myWork3)
        ShowBio()
        btn_myWork3.setOnClickListener {
            if (isBioLoaded)
                ShowWorks()
            else if (isReviewsLoaded)
                ShowWorks()
            else
                ShowWorks()
        }

        btn_Bio3.setOnClickListener {
            if (isWorksLoaded)
                ShowBio()
            else if (isReviewsLoaded)
                ShowBio()
            else ShowBio()
            btn_reviews3.setOnClickListener {
                if (isBioLoaded)
                    ShowReviews()
                else if (isWorksLoaded)
                    ShowReviews()

                else
                    ShowReviews()

            }

        }

        btn_share3.setOnClickListener {
            val imageUri = Uri.parse("android.resource://" + packageName
                    + "/drawable/" + "profile3_cut1")
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Hello! my name is Jimmy Wong i am a stylist " +
                        "based in Maryland above is one of my haircuts! " +
                        "if you want to see more please check me out at www.hairstyles.com/JimmyWong")
            shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

            shareIntent.type = "image/jpeg"
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(Intent.createChooser(shareIntent, "send"))




        }


        btn_mainmenu3.setOnClickListener {
            val context = this
            val profileIntent = Intent(context,MainActivity::class.java)
            startActivity(profileIntent)
            finish()


        }
    }

    fun ShowBio() {
        val transaction = manager.beginTransaction()
        val fragment = Profile3frgBio()
        transaction.replace(R.id.profile_frg_holder3, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = true
        isWorksLoaded = false
        isReviewsLoaded =false



    }


    fun ShowWorks() {
        val transaction = manager.beginTransaction()
        val fragment = Profile3frgWorks()
        transaction.replace(R.id.profile_frg_holder3, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = false
        isWorksLoaded=true
        isReviewsLoaded = false

    }

    fun ShowReviews() {
        val transaction = manager.beginTransaction()
        val fragment = Profile3frgReviews()
        transaction.replace(R.id.profile_frg_holder3, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = false
        isWorksLoaded=false
        isReviewsLoaded= true
    }
}