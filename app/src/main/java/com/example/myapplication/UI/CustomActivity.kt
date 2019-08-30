package com.example.myapplication.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.haircare.R
import kotlinx.android.synthetic.main.custom_view2.*
import kotlinx.android.synthetic.main.recycler.*

class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_view2)
        button_6.setOnClickListener {
            val context = this
            val profileIntent = Intent(context, MainActivity::class.java)
            startActivity(profileIntent)
            finish()


        }


    }


}
