package com.example.cities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.lettersRecyclerView

        recyclerView.adapter = LetterAdapter()
    }
}