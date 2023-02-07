package com.example.perrodex.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perrodex.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {

    private val  dogListViewModel: DogListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.dogRv
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = DogAdapter()
        recyclerView.adapter = adapter


        dogListViewModel.dogList.observe(this){
            dogList ->
            adapter.submitList(dogList)
        }
    }
}