package com.example.kitties.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cat(
    @DrawableRes val picture: Int,
    @StringRes val name: Int
)
