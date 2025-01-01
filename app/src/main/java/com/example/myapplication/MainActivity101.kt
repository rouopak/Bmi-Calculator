package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity101 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main101)

        val plainTextInput = findViewById<EditText>(R.id.editTextText2)
        val age = findViewById<EditText>(R.id.editTextNumber)
        val genderRadioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)
        val switchButton = findViewById<Button>(R.id.sub_button)

        switchButton.setOnClickListener {
            val text = plainTextInput.text.toString()
            val num2 = age.text.toString()
            val selectedGenderId = genderRadioGroup.checkedRadioButtonId

            when {
                text.isEmpty() -> {
                    Toast.makeText(this, "Please enter your Name", Toast.LENGTH_SHORT).show()
                }
                num2.isEmpty() -> {
                    Toast.makeText(this, "Please enter your Age", Toast.LENGTH_SHORT).show()
                }
                (num2.toIntOrNull() ?: 0) < 15 -> {
                    Toast.makeText(this, "Your Age should be at least 15", Toast.LENGTH_SHORT).show()
                }
                selectedGenderId == -1 -> {
                    Toast.makeText(this, "Please select a Gender", Toast.LENGTH_SHORT).show()
                }
                else -> {

                    val selectedGender = findViewById<RadioButton>(selectedGenderId).text
                    val genderbender = selectedGender.toString()

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("name", text)
                    intent.putExtra("gender", genderbender)


                    startActivity(intent)
                }
            }
        }
    }
}
