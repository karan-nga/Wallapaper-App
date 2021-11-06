package com.example.wallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wallpaperapp.Fragments.DownloadFragment
import com.example.wallpaperapp.Fragments.HomeFragment
import com.example.wallpaperapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.icHome.setOnClickListener{
            //Toast.makeText(this,"home",Toast.LENGTH_SHORT).show()
            replaceFragment(HomeFragment())
        }
        binding.icDownload.setOnClickListener{
            //Toast.makeText(this,"download",Toast.LENGTH_SHORT).show()
            replaceFragment(DownloadFragment())
        }
    }
    fun replaceFragment(fragment:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_replace, fragment)
        transaction.commit()
    }
}