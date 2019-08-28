package com.example.myapplication.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.haircare.R
import com.example.haircare.fragments.profile1_bio
import com.example.haircare.fragments.profile1_works
import kotlinx.android.synthetic.main.profile_1.*

class ProfileActivity : AppCompatActivity() {
    var isBioLoaded = true
    var isWorksLoaded = false
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_1)

        val works = findViewById<Button>(R.id.btn_myWork)
        ShowBio()
        btn_myWork.setOnClickListener {
            if (isBioLoaded)
                ShowWorks()
            else
                ShowBio()
        }

        btn_Bio.setOnClickListener {
            if (isWorksLoaded)
                ShowBio()
            else {
                ShowWorks()
            }

        }
    }

    fun ShowBio() {
        val transaction = manager.beginTransaction()
        val fragment = profile1_bio()
        transaction.replace(R.id.profile_frg_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = true



    }


    fun ShowWorks() {
        val transaction = manager.beginTransaction()
        val fragment = profile1_works()
        transaction.replace(R.id.profile_frg_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isBioLoaded = false
        isWorksLoaded=true
    }
}
