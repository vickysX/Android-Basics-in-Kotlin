package com.example.kitties

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kitties.adapter.CatAdapter
import com.example.kitties.data.CatSource
import com.example.kitties.databinding.ActivityVerticalBinding

class VerticalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVerticalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerticalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalRecyclerView.adapter = CatAdapter(this, CatSource().loadCats())
        binding.verticalRecyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}