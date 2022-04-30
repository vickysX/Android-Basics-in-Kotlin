package com.example.kitties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kitties.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalButton.setOnClickListener { launchVertical() }

        binding.gridButton.setOnClickListener { launchGrid() }

    }

    private fun launchVertical() {
        listIntent = Intent(this, VerticalActivity::class.java)
        startActivity(listIntent)
    }

    private fun launchGrid() {
        listIntent = Intent(this, GridActivity::class.java)
        startActivity(listIntent)
    }
}