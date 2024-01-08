package com.example.prak4

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_category, parent, false)){
    private var txttittle: TextView? = null
    private  var imgview: ImageView? =null

    init {
        imgview = itemView.findViewById(R.id.imgCategory)
        txttittle = itemView.findViewById(R.id.tvCategory)
    }
    fun bind(data: CategoryDataClass){
        imgview?.setImageResource(data.imgview)
        txttittle?.setText(data.txttitle)
    }
}