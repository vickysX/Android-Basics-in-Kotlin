package com.example.dogglers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dogglers.adapter.ItemAdapter
import com.example.dogglers.data.Datasource
import com.example.dogglers.databinding.ActivityMainBinding
import com.example.dogglers.databinding.HorizontalActivityBinding
import com.example.dogglers.layout.Layouts
import com.example.dogglers.model.Dog

class HorizontalActivity : AppCompatActivity() {

    private lateinit var binding: HorizontalActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HorizontalActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.horizontalRecyclerView.adapter = ItemAdapter(this, Layouts.HORIZONTAL)

        binding.horizontalRecyclerView.setHasFixedSize(true)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }
}