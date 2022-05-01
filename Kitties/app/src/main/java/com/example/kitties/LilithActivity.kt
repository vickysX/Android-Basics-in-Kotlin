package com.example.kitties

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kitties.databinding.ActivityLilithBinding

class LilithActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lilith)
        val imageView = findViewById<ImageView>(R.id.lilith_picture)
        val name = findViewById<TextView>(R.id.lilith_name)
        imageView.setImageResource(R.drawable.lilith)
        imageView.setOnClickListener {
            val queryUrl = Uri.parse("${MainActivity.SEARCH_PREFIX}${name.text}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
        title = "Lilith"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}