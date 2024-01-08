package com.example.prak4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PostAdapter(private  val list: ArrayList<PostResponseDataClass>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
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

        fun bind(postResponseDataClass: PostResponseDataClass) {
            with(itemView){
                val title = "${postResponseDataClass.name}"
                val desc = "${postResponseDataClass.desc}"
                val img = "${postResponseDataClass.img}"

                descitem?.text = desc
                namaitem?.text   = title
                Picasso.get().load(img).into(imgitem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_home, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
}