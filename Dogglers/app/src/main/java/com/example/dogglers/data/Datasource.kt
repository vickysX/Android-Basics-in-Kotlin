package com.example.dogglers.data

import com.example.dogglers.R
import com.example.dogglers.model.Dog

class Datasource {
    fun loadDogs(): List<Dog> {
        return listOf<Dog>(
            Dog(R.drawable.bella,
                "Bella",
                "14",
                "Chasing sea foam"),
            Dog(R.drawable.faye,
                "Faye",
                "8",
                "Digging in the garden"),
            Dog(R.drawable.frankie,
                "Frankie",
                "2",
                "Stealing socks"),
            Dog(R.drawable.leroy,
                "Leroy",
                "4",
                "Sleeping in dangerous places"),
            Dog(R.drawable.nox,
                "Nox",
                "8",
                "Meeting new animals"),
            Dog(R.drawable.tzeitel,
                "Tzeitel",
                "7",
                "Sunbathing")
        )
    }
}