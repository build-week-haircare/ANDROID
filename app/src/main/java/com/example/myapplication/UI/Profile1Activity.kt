package com.example.myapplication.UI

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.haircare.R
import com.example.haircare.fragments.Profile1Bio
import com.example.haircare.fragments.Profile1frgReviews
import com.example.haircare.fragments.Profile1Works
import kotlinx.android.synthetic.main.profile_1.*

class Profile1Activity : AppCompatActivity() {
    var isBioLoaded = true
    var isWorksLoaded = false
    var isReviewsLoaded = false
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_1)

        val works = findViewById<Button>(R.id.btn_myWork)
        ShowBio()
        btn_myWork.setOnClickListener {
            if (isBioLoaded)
                ShowWorks()
            else if (isReviewsLoaded)
                ShowWorks()
            else
                ShowWorks()
        }

        btn_Bio.setOnClickListener {
            if (isWorksLoaded)
                ShowBio()
            else if (isReviewsLoaded)
                ShowBio()
            else ShowBio()
            btn_reviews.setOnClickListener {
                if (isBioLoaded)
                    ShowReviews()
                else if (isWorksLoaded)
                    ShowReviews()

                    else
                    ShowReviews()

            }

        }
        btn_share1.setOnClickListener {
            val imageUri = Uri.parse("android.resource://" + packageName
                    + "/drawable/" + "profile1_cut1")
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Hello! my name is Chad Watson i am a stylist " +
                        "based in New York above is some of my haircuts! " +
                        "if you want to see more please check me out at www.hairstyles.com/ChadWatson")
            shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

            shareIntent.type = "image/jpeg"
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(Intent.createChooser(shareIntent, "send"))




        }


        btn_mainmenu1.setOnClickListener {
            val context = this
            val profileIntent = Intent(context,MainActivity::class.java)
            startActivity(profileIntent)
            finish()


        }

    }

    fun ShowBio() {
        val transaction = manager.beginTransaction()
        val fragment = Profile1Bio()
        transaction.replace(R.id.profile_frg_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = true
        isWorksLoaded = false
        isReviewsLoaded =false



    }


    fun ShowWorks() {
        val transaction = manager.beginTransaction()
        val fragment = Profile1Works()
        transaction.replace(R.id.profile_frg_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = false
        isWorksLoaded=true
        isReviewsLoaded = false

    }

    fun ShowReviews() {
        val transaction = manager.beginTransaction()
        val fragment = Profile1frgReviews()
        transaction.replace(R.id.profile_frg_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = false
        isWorksLoaded=false
        isReviewsLoaded= true
    }
}
