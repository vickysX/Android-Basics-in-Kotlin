package com.example.animals.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Animal(
    @DrawableRes val picture: Int,
    @StringRes val speciesName: Int,
    val animalClass: String
)
