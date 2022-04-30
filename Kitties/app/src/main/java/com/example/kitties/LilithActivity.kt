package com.example.kitties

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kitties.databinding.ActivityLilithBinding

class LilithActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLilithBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLilithBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}