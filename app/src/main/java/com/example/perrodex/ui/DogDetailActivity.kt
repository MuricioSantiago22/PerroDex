package com.example.perrodex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.perrodex.R
import com.example.perrodex.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}