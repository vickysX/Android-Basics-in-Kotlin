package com.example.kitties.data

import com.example.kitties.R
import com.example.kitties.model.Cat

class CatSource {
    fun loadCats(): List<Cat> {
        return listOf(
            Cat(R.drawable.nike_kokori, R.string.nike_kokori),
            Cat(R.drawable.lilith, R.string.lilith)
        )
    }
}