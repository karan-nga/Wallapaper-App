package com.example.wallpaperapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.FinalView
import com.example.wallpaperapp.R
import com.example.wallpaperapp.dp.BomModel

class BomAdapter(val requireContext:Context, val listBestOfBest:ArrayList<BomModel>): RecyclerView.Adapter<BomAdapter.bomViewHolder>() {
    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView =itemView.findViewById<ImageView>(R.id.image_bob)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
       return bomViewHolder(
           LayoutInflater.from(requireContext).inflate(R.layout.item_bob,parent,false)
       )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listBestOfBest[position].link).into(holder.imageView)
        holder.itemView.setOnClickListener {
            val intent=Intent(requireContext,FinalView::class.java)
            intent.putExtra("link",listBestOfBest[position].link)
            requireContext.startActivities(arrayOf(intent));
        }
    }

    override fun getItemCount()=listBestOfBest.size
}