package com.example.temperatureconverter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.temperatureconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.convertButton.setOnClickListener { tempConversion() }
        binding.temperatureInputEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }

    private fun tempConversion() {
        val temperature: Double? = binding.temperatureInputEditText.text.toString().toDoubleOrNull()
        if (temperature == null) {
            binding.result.text = ""
            return
        } else {
            val finalTemperature = when (binding.startUnityMeasure.checkedRadioButtonId) {
                R.id.celsiusOption -> calculateFahrenheit(temperature)
                else -> calculateCelsius(temperature)
            }
            binding.result.text = getString(
                R.string.result,
                finalTemperature
            ) // getString(<string_resource_id>, <value_to_insert_in_place_of_%s>)
        }
    }

    private fun calculateFahrenheit(tempCelsius: Double): String {
        val tempFahr = tempCelsius.times(1.8).plus(32)
        return "${formatTemp(tempFahr)} F°"
    }

    private fun calculateCelsius(tempFahrenheit: Double): String {
        val tempCel = tempFahrenheit.minus(32).div(0.556)
        return "${formatTemp(tempCel)} C°"
    }

    private fun formatTemp(aTemp: Double): String {
        var tempText = aTemp.toString()
        if (binding.roundSwitch.isChecked) tempText = String.format("%.2f", aTemp)
        return tempText
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KEYCODE_ENTER) {
            // hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}