package com.example.kitties

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kitties.adapter.CatAdapter
import com.example.kitties.data.CatSource
import com.example.kitties.databinding.ActivityGridBinding

class GridActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGridBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecyclerView.adapter = CatAdapter(this, CatSource().loadCats())
        binding.gridRecyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.gridRecyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}