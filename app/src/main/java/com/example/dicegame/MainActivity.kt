package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI References
        val rollButton: Button = findViewById(R.id.rollButton)
        val dice1: ImageView = findViewById(R.id.dice1)
        val dice2: ImageView = findViewById(R.id.dice2)
        val resultText: TextView = findViewById(R.id.result)

        // Roll Button Action
        rollButton.setOnClickListener {
            val diceRoll1 = Random.nextInt(6) + 1
            val diceRoll2 = Random.nextInt(6) + 1
            val total = diceRoll1 + diceRoll2

            // Update Dice Images
            dice1.setImageResource(getDiceImage(diceRoll1))
            dice2.setImageResource(getDiceImage(diceRoll2))

            // Update Result
            resultText.text = "Result = $total"
        }
    }

    // Helper: Map dice number to drawable
    private fun getDiceImage(roll: Int): Int {
        return when (roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
