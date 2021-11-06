package com.example.wallpaperapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperapp.R
import com.example.wallpaperapp.dp.Categ

class CateAdapter(val requireContext:Context, val listOfCate: ArrayList<Categ>): RecyclerView.Adapter<CateAdapter.bomViewHolder>() {
    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView =itemView.findViewById<ImageView>(R.id.cateima)
        val name: TextView =itemView.findViewById<TextView>(R.id.textcat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
       return bomViewHolder(
           LayoutInflater.from(requireContext).inflate(R.layout.item_catg,parent,false)
       )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listOfCate[position].link).into(holder.imageView)
        holder.name.text=listOfCate[position].name

    }

    override fun getItemCount()=listOfCate.size
}