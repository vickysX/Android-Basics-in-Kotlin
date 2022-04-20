package com.example.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //equivalente del metodo main
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            rollDice()
            //toast.show()
        }

        // roll the dice when the app starts, just to show the user how it works and what it does
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // create new Dice object, sets its sides to 6, and rolls the dice
        val firstDice = Dice(6)
        val firstDiceRoll = firstDice.roll()

        // second dice
        val secondDice = Dice(6)
        val secondDiceRoll = secondDice.roll()

        // Find the image view in the layout
        val firstDiceImage: ImageView = findViewById(R.id.imageView5)
        val secondDiceImage: ImageView = findViewById(R.id.imageView2)

        // Add a text description to the image view (the result of the roll)
        firstDiceImage.contentDescription = firstDiceRoll.toString()
        secondDiceImage.contentDescription = secondDiceRoll.toString()

        // Determine which drawable resource id to use based on the dice roll
        val firstDrawableResource = faces(firstDiceRoll)
        val secondDrawableResource = faces(secondDiceRoll)

        // Set the correct image based on the result of the dice roll
        firstDiceImage.setImageResource(firstDrawableResource)
        secondDiceImage.setImageResource(secondDrawableResource)

        // display the results
        //val resultTextView1: TextView = findViewById(R.id.textView)
        //resultTextView1.text = firstDiceRoll.toString()
    }

    private fun faces(roll: Int): Int {
        val resource = when (roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return resource
    }
}

class Dice(val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}