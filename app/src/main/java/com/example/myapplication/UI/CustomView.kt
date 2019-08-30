package com.example.myapplication.UI

import android.content.Context
import android.media.Image
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.haircare.R
import org.w3c.dom.Text

class CustomView:LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    val profileList = listOf(
       R.drawable.ashley_profile,
        R.drawable.chad_profile,
        R.drawable.jimmy_profile
    )

    var pointer =0
    fun incrementPointer() {
        pointer++
        if(pointer >= profileList.size) {
            pointer =0
        }
    }
    fun decrementPointer() {
        pointer--
        if (pointer < 0) {
            pointer = profileList.size

        }
    }
    init {
        val imageView = LayoutInflater.from(context).inflate(R.layout.custom_view,this,false) as ImageView

        val profileImageview= ImageView(context)
        profileImageview.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ashley_profile))


        val previousImageView = ImageView(context)
        previousImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_media_previous))
        previousImageView.setOnClickListener {
           decrementPointer()
           // textView.text=locationList[pointer]
        }

        val nextImageView = ImageView(context)
        nextImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_media_next))
        nextImageView.setOnClickListener {
            incrementPointer()
            //textView.text = locationList[pointer]
        }
        val dislike = ImageView(context)
        dislike.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.baseline_thumb_down_black_18dp))
        dislike.setOnClickListener {
            dislike.setBackgroundColor(resources.getColor(android.R.color.holo_red_dark))

        }
        val like = ImageView(context)
        like.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.baseline_thumb_up_black_18dp))
        like.setOnClickListener {
            like.setBackgroundColor(resources.getColor(android.R.color.holo_blue_bright))
        }

        orientation = HORIZONTAL
        addView(previousImageView)
        addView(imageView)
        addView(nextImageView)
        addView(like)
        addView(dislike)
    }



}