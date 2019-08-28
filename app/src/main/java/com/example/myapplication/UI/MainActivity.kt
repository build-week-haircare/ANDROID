package com.example.myapplication.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.haircare.R
import com.example.myapplication.Adapter.Haircutadapter
import com.example.myapplication.model.HairRepo
import com.example.myapplication.model.haircuts
import kotlinx.android.synthetic.main.buildadapter.*
import kotlinx.android.synthetic.main.recycler.*

//need to commit for a commit
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf<haircuts>()

        HairRepo.createhairlist()


        my_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = Haircutadapter(data)
        my_view.layoutManager = manager
        my_view.adapter = adapter

    }
}
