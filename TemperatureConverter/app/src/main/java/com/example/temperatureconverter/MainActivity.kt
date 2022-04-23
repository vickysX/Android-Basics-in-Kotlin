package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.temperatureconverter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.convertButton.setOnClickListener { tempConversion() }
    }

    private fun tempConversion() {
        var temperature: Double? = binding.temperatureInput.text.toString().toDoubleOrNull()
        if (temperature == null) {
            binding.result.text = ""
            return
        } else {
            val finalTemperature = when (binding.startUnityMeasure.checkedRadioButtonId) {
                R.id.celsiusOption -> calculateFahrenheit(temperature)
                else -> calculateCelsius(temperature)
            }
            binding.result.text = getString(R.string.result, finalTemperature)
        }
    }

    private fun calculateFahrenheit(tempCelsius: Double): String {
        val tempFahr = tempCelsius.times(1.8).plus(32)
        return String.format("%.2f", tempFahr) + " F°"
    }

    private fun calculateCelsius(tempFahrenheit: Double): String {
        val tempCel = tempFahrenheit.minus(32).div(0.556)
        return String.format("%.2f", tempCel) + " C°"
    }
}