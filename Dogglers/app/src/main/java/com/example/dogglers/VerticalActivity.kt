package com.example.dogglers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dogglers.adapter.ItemAdapter
import com.example.dogglers.data.Datasource
import com.example.dogglers.databinding.VerticalActivityBinding
import com.example.dogglers.layout.Layouts

class VerticalActivity : AppCompatActivity() {
    private lateinit var binding: VerticalActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VerticalActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalRecyclerView.adapter = ItemAdapter(this, Layouts.VERTICAL)

        // Specify fixed size to improve performance
        binding.verticalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}