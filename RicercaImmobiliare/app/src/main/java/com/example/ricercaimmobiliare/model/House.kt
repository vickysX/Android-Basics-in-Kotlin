package com.example.ricercaimmobiliare.model


import androidx.annotation.DrawableRes
import java.text.NumberFormat

data class House(
    @DrawableRes val picture: Int,
    val location: String,
    val price: Double,
    val description: String
) {
    fun getFormattedPrice(): String {
        return NumberFormat.getCurrencyInstance().format(price)
    }
}
