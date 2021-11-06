package com.example.wallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wallpaperapp.databinding.ActivityFinalViewBinding

class FinalView : AppCompatActivity() {
    lateinit var binding:ActivityFinalViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFinalViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url=intent.getStringExtra("link")
        Glide.with(this).load(url).into(binding.finalWall)

        binding.setwall.setOnClickListener{

        }
    }
}