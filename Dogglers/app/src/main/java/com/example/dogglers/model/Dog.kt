package com.example.dogglers.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dog(
    @DrawableRes val picture: Int,
    val name: String,
    val age: String,
    val hobbies: String)
