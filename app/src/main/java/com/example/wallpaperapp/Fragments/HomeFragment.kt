package com.example.wallpaperapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaperapp.Adapter.BomAdapter
import com.example.wallpaperapp.Adapter.CateAdapter
import com.example.wallpaperapp.databinding.FragmentHomeBinding
import com.example.wallpaperapp.dp.BomModel
import com.example.wallpaperapp.dp.Categ
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {


lateinit var binding: FragmentHomeBinding
lateinit var db:FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)
        db=FirebaseFirestore.getInstance()
        db.collection("BestOfTheBest").addSnapshotListener { value, error ->
            val listBestOfBest= arrayListOf<BomModel>()
            val data=value?.toObjects(BomModel::class.java)
            listBestOfBest.addAll(data!!)
            binding.recyclebob.layoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false
            )
            binding.recyclebob.adapter=BomAdapter(requireContext(),listBestOfBest)
        }
        db.collection("categories").addSnapshotListener { value, error ->
            val listOfCate= arrayListOf<Categ>()
            val data=value?.toObjects(Categ::class.java)
            listOfCate.addAll(data!!)
            binding.recyclecatg.layoutManager=GridLayoutManager(requireContext(),2)
            binding.recyclecatg.adapter=CateAdapter(requireContext(),listOfCate )
        }

      return binding.root
    }



}