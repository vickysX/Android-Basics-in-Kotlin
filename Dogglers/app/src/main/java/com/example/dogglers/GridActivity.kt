package com.example.dogglers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dogglers.adapter.ItemAdapter
import com.example.dogglers.data.Datasource
import com.example.dogglers.databinding.ActivityMainBinding
import com.example.dogglers.databinding.GridActivityBinding
import com.example.dogglers.layout.Layouts

class GridActivity : AppCompatActivity() {
    private lateinit var binding: GridActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GridActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecyclerView.adapter = ItemAdapter(this, Layouts.GRID)
        binding.gridRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.gridRecyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}