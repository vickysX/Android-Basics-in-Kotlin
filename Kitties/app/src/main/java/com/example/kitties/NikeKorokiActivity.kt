package com.example.kitties

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NikeKorokiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nike_koroki)
        title = "Nike & Koroki"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}