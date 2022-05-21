package com.example.ricercaimmobiliare.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HouseViewModel : ViewModel() {

    private var _priceRange = MutableLiveData<IntRange>()
    val priceRange: LiveData<IntRange> get() = _priceRange

    private var _location = MutableLiveData<String>()
    val location: LiveData<String> get() = _location

    fun setPriceRange(max: Int) {
        _priceRange.value = 150..max
    }

    fun setLocation() {}

    fun resetSearch() {}
}