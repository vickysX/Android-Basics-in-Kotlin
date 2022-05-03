package com.example.tassaaffitto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import com.example.tassaaffitto.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var webIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculationButton.setOnClickListener { calcolaRisultato() }

        // make the string link spannable, underline it, and set it as text of its TextView
        val stringLink = getString(R.string.link)
        val spannableString = SpannableString(stringLink)
        spannableString.setSpan(UnderlineSpan(), 0, spannableString.length, 0)
        binding.linkAgenziaEntrate.text = spannableString

        binding.linkAgenziaEntrate.setOnClickListener { apriSitoAgenzia() }
    }

    private fun calcolaRisultato() {
        val canone = binding.canoneAnnuoEdit.text.toString().toDoubleOrNull()
        if (canone == 0.00 || canone == null) {
            binding.introResult.text = ""
            binding.result.text = ""
            return
        }
        val totalTax = canone * 0.21
        val result: Double
        when (binding.calculateOptions.checkedRadioButtonId) {
            R.id.prima_rata -> {
                result = calcolaPrimaRata(totalTax)
                binding.introResult.text = getString(R.string.intro_result, "giugno")
            }
            R.id.seconda_rata -> {
                result = calcolaSecondaRata(totalTax)
                binding.introResult.text = getString(R.string.intro_result, "novembre")
            }
            else -> {
                result = calcolaTerzaRata(totalTax)
                binding.introResult.text = getString(R.string.intro_result, "giugno dell'anno prossimo")
            }
        }
        binding.result.text = NumberFormat.getCurrencyInstance().format(result)
        binding.resultIcon.setImageResource(R.drawable.ic_money_off)
    }

    private fun calcolaPrimaRata(total: Double): Double {
        return total * 0.95 * 0.4
    }

    private fun calcolaSecondaRata(total: Double): Double {
        return total * 0.95 * 0.6
    }

    private fun calcolaTerzaRata(total: Double): Double {
        return total * 0.05
    }

    private fun apriSitoAgenzia() {
        val queryUrl = Uri.parse("https://www.agenziaentrate.gov.it/portale/")
        webIntent = Intent(Intent.ACTION_VIEW, queryUrl)
        startActivity(webIntent)
    }
}