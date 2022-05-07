package com.example.animals.data

import com.example.animals.R
import com.example.animals.model.Animal

class AnimalSource {
    fun loadAnimals(): List<Animal> {
        return listOf(
            Animal(R.drawable.nike_kokori, R.string.cat, "Mammals"),
            Animal(R.drawable.bella, R.string.dog, "Mammals"),
            Animal(R.drawable.phoenix, R.string.phoenix, "Birds"),
            Animal(R.drawable.snake, R.string.snake, "Reptiles")
        )
    }
}