package com.example.myapplication.UI

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.haircare.R

class CustomView(context: Context, attributeSet: AttributeSet, defStyleAttr:Int, defStyleRes: Int):
        LinearLayout(context,attributeSet,defStyleAttr,defStyleRes){

     //what the layout gets its data from
    init{
      val imageView = LayoutInflater.from(context).inflate(R.layout.custom_view, this, false) as ImageView
        imageView.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.profilepicproject))

        val previousImageView = ImageView(context)
        previousImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_media_previous))

        val nextImageView = ImageView(context)
        nextImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_media_next))


        // orientation of the layout and order of what the views are from top to bottom
        orientation = HORIZONTAL
        addView(previousImageView)
        addView(imageView)
        addView(nextImageView)
    }
}