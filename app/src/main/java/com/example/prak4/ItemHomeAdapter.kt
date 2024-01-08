package com.example.prak4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemHomeAdapter(private val data: ArrayList<ItemHomeData>): RecyclerView.Adapter<ItemHomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemHomeViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemHomeViewHolder, position: Int) {
        holder.bind(data[position])
    }
}