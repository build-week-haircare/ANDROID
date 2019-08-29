package com.example.myapplication.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.haircare.R
import com.example.haircare.fragments.*
import kotlinx.android.synthetic.main.activity_profile_2_.*
import kotlinx.android.synthetic.main.profile_1.*

class Profile_2_Activity : AppCompatActivity(){
    var isBioLoaded = true
    var isWorksLoaded = false
    var isReviewsLoaded = false
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_2_)

        val works = findViewById<Button>(R.id.btn_myWork2)
        ShowBio()
        btn_myWork2.setOnClickListener {
            if (isBioLoaded)
                ShowWorks()
            else if (isReviewsLoaded)
                ShowWorks()
            else
                ShowWorks()
        }

        btn_Bio2.setOnClickListener {
            if (isWorksLoaded)
                ShowBio()
            else if (isReviewsLoaded)
                ShowBio()
            else ShowBio()
            btn_reviews2.setOnClickListener {
                if (isBioLoaded)
                    ShowReviews()
                else if (isWorksLoaded)
                    ShowReviews()

                else
                    ShowReviews()

            }

        }
    }

    fun ShowBio() {
        val transaction = manager.beginTransaction()
        val fragment = profile2_frg_bio()
        transaction.replace(R.id.profile_frg_holder2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = true
        isWorksLoaded = false
        isReviewsLoaded =false



    }


    fun ShowWorks() {
        val transaction = manager.beginTransaction()
        val fragment = profile2_frg_works()
        transaction.replace(R.id.profile_frg_holder2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = false
        isWorksLoaded=true
        isReviewsLoaded = false

    }

    fun ShowReviews() {
        val transaction = manager.beginTransaction()
        val fragment = profile2_frg_reviews()
        transaction.replace(R.id.profile_frg_holder2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = false
        isWorksLoaded=false
        isReviewsLoaded= true
    }
}