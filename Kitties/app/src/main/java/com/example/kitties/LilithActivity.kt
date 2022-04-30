package com.example.kitties

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.kitties.databinding.ActivityLilithBinding

class LilithActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lilith)
        val imageView = findViewById<ImageView>(R.id.lilith_picture)
        imageView.setImageResource(R.drawable.lilith)
    }
}