package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.haircare.R
import com.example.myapplication.model.HairRepo.Companion.hairlist
import com.example.myapplication.model.Haircuts
import kotlinx.android.synthetic.main.buildadapter.view.*

class Haircutadapter(val data: MutableList<Haircuts>): RecyclerView.Adapter<Haircutadapter.ViewHolder>() {

//the image views
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val profile: ImageView = view.profile_image
        val  hair1 : ImageView = view.cut_1
        val hair2 : ImageView = view.cut_2
        val hair3 : ImageView = view.cut_3
        val text : TextView = view.bio

    fun bindmodel(hair:Haircuts){
        profile.setImageResource(hair.profilepic)
        hair1.setImageResource(hair.cut1)
        hair2.setImageResource(hair.cut2)
        hair3.setImageResource(hair.cut3)
        text.text = hair.bio
    }

    }

     // calling the layout Inflater to get what our images will be
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val viewGroup =  LayoutInflater.from(parent.context).inflate(R.layout.buildadapter,parent, false)
       return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }
       //setting our viewholder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       /*holder.profile.setImageDrawable(data[position].profilepic)
       holder.hair1.setImageDrawable(data[position].cut1)
       holder.hair2.setImageDrawable(data[position].cut2)
       holder.hair3.setImageDrawable(data[position].cut3)
       holder.text.text = data[position].bio*/

       val hair = hairlist[position]


    }

}