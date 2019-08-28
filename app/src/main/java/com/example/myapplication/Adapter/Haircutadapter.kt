package com.example.myapplication.Adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.haircare.R
import com.example.myapplication.model.HairRepo.Companion.hairlist
import com.example.myapplication.model.haircuts
import kotlinx.android.synthetic.main.buildadapter.view.*

class Haircutadapter(val data: MutableList<haircuts>): RecyclerView.Adapter<Haircutadapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val profile: ImageView = view.profile_image
        val  hair1 : ImageView = view.cut_1
        val hair2 : ImageView = view.cut_2
        val hair3 : ImageView = view.cut_3
        val text : TextView = view.bio


        fun bindmodel(hair:haircuts){
            profile.setImageResource(hair.profilepic)
            hair1.setImageResource(hair.cut1)
            hair2.setImageResource(hair.cut2)
            hair3.setImageResource(hair.cut3)
            text.text = hair.bio
        }



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(parent.context)
          .inflate(R.layout.buildadapter,parent,false) as View)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val hair = hairlist[position]
        holder.bindmodel(hair)
    }

}