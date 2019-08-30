package com.example.myapplication.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haircare.R
import com.example.myapplication.Adapter.Haircutadapter
import com.example.myapplication.model.HairRepo
import kotlinx.android.synthetic.main.buildadapter.*
import kotlinx.android.synthetic.main.profile_1.*

import kotlinx.android.synthetic.main.recycler.*

//need to commit for a commit
class recyclertest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler)



        HairRepo.createhairlist()


        my_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@recyclertest)
            adapter = Haircutadapter(HairRepo.hairlist)

        }
        button_5.setOnClickListener {
            val context = this
            val profileIntent = Intent(context, MainActivity::class.java)
            startActivity(profileIntent)
            finish()


        }
    }
}