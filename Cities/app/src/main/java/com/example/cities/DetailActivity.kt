package com.example.cities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cities.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterId = intent?.extras?.getString(LETTER).toString()

        binding.citiesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.citiesRecyclerView.adapter = CityAdapter(letterId, this)
        binding.citiesRecyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        title = "Cities that start with $letterId"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}