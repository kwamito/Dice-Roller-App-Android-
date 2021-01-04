package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            rollDice()
        }
        rollDice()
    }

    private fun rollDice() {
        // Create a new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val secondDice = Dice(6)
        val diceRoll = dice.roll()
        val secondDiceRoll = secondDice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val secondDiceImage: ImageView = findViewById(R.id.imageView2)

        //Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val secondDrawableResource = when(secondDiceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the image view resource with the correct drawable resourceID
        diceImage.setImageResource(drawableResource)
        secondDiceImage.setImageResource(secondDrawableResource)

        // Set the content description to the random number returned
        diceImage.contentDescription = diceRoll.toString()
        secondDiceImage.contentDescription = secondDiceRoll.toString()
    }

/*
* This class take in a value which is an integer for the number of sides of the dice and returns
* random numbers in that range*/

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()

        }
    }
}