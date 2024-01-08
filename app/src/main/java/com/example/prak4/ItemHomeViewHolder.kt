package com.example.prak4

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemHomeViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_item_home, parent, false)){
    private var namaitem: TextView? = null
    private var descitem: TextView? = null
    private var uploadat: TextView? = null
    private var username: TextView? = null
    private  var imgitem: ImageView? =null

    init {
        imgitem = itemView.findViewById(R.id.imgItem)
        namaitem = itemView.findViewById(R.id.namaItem)
        descitem = itemView.findViewById(R.id.itemDesc)
        uploadat = itemView.findViewById(R.id.tvUploadedAt)
        username = itemView.findViewById(R.id.tvUsername)
    }
    fun bind(data: ItemHomeData){
        imgitem?.setImageResource(data.imgitem)
        namaitem?.setText(data.namaitem)
        descitem?.setText(data.descitem)
        uploadat?.setText(data.uploadat)
        username?.setText(data.username)
    }
}