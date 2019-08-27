package com.example.myapplication.Adapter

import android.media.Image
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.haircuts
import kotlinx.android.synthetic.main.buildadapter.view.*

class Haircutadapter(val data: MutableList<haircuts>): RecyclerView.Adapter<Haircutadapter.ViewHolder>() {


    class ViewHolder(view:ViewGroup): RecyclerView.ViewHolder(view){
        val profile: ImageView = view.profile_image
        val  hair1 : ImageView = view.cut_1
        val hair2 : ImageView = view.cut_2
        val hair3 : ImageView = view.cut_3
        val text : TextView = view.bio
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}