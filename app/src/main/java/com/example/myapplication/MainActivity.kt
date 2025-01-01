package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val naam = intent.getStringExtra("name")
        val a = intent.getStringExtra("gender")


        Log.d("MainActivity", "Received Name: $naam")
        Log.d("MainActivity", "Received Gender: $a")


        val calculateButton = findViewById<AppCompatButton>(R.id.calcButton)
        calculateButton.setOnClickListener {
            val weightValue = findViewById<Slider>(R.id.slider_1).value
            val heightValue = findViewById<Slider>(R.id.slider_2).value
            val heightInMeters = heightValue / 100
            val bmi = weightValue / (heightInMeters * heightInMeters)

            Log.d("MainActivity", "BMI: $bmi")
            Log.d("MainActivity", "Weight: $weightValue")
            Log.d("MainActivity", "Height: $heightValue")


            when {
                bmi <= 15 -> findViewById<TextView>(R.id.comment).text = "$naam is Severly Thin \n$naam should eat more"
                bmi > 15 && bmi < 18.5 -> findViewById<TextView>(R.id.comment).text = "$naam is Underweight"
                bmi >= 18.5 && bmi < 25 -> findViewById<TextView>(R.id.comment).text = "$naam is Healthy Weight"
                bmi >= 25 && bmi < 30 -> findViewById<TextView>(R.id.comment).text = "$naam is Overweight"
                bmi >= 30 && bmi < 40 -> findViewById<TextView>(R.id.comment).text = "$naam is Obese"
                bmi >= 40 -> {
                    if (a == "Male") {
                        findViewById<TextView>(R.id.comment).text ="Kam khana khaya kar Mote"
                    } else {
                        findViewById<TextView>(R.id.comment).text ="Kam khana khaya kar Moti"
                    }
                }
            }



            findViewById<TextView>(R.id.answer).text = bmi.toString()


            Toast.makeText(this, "Data has been submitted", Toast.LENGTH_SHORT).show()
        }


        val backButton = findViewById<AppCompatButton>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}
