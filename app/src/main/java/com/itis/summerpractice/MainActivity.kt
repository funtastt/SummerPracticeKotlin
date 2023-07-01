package com.itis.summerpractice

import android.R.color
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat


class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var height: EditText
    lateinit var weight: EditText
    lateinit var age: EditText
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        name = findViewById(R.id.nameEdit)
        height = findViewById(R.id.heightEdit)
        weight = findViewById(R.id.weightEdit)
        age = findViewById(R.id.ageEdit)
        result = findViewById(R.id.resultText)


        val btn: Button = findViewById(R.id.button)

        val errorColor = ColorStateList.valueOf(Color.RED)
        val defaultColor = ColorStateList.valueOf(Color.BLACK)

        height.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (height.text.isEmpty()) return
                if (height.text.toString().toInt() !in 0..250) {
                    Toast.makeText(applicationContext, "Рост должен быть в диапазоне от 0 до 250", Toast.LENGTH_SHORT).show()
                    ViewCompat.setBackgroundTintList(height, errorColor)
                } else {
                    ViewCompat.setBackgroundTintList(height, defaultColor)
                }
            }
        })

        weight.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (weight.text.isEmpty()) return
                if (weight.text.toString().toDouble() !in 0.0..250.0) {
                    Toast.makeText(applicationContext, "Вес должен быть в диапазоне от 0 до 250", Toast.LENGTH_SHORT).show()
                    ViewCompat.setBackgroundTintList(weight, errorColor)
                } else {
                    ViewCompat.setBackgroundTintList(weight, defaultColor)
                }
            }
        })

        age.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (age.text.isEmpty()) return
                if (age.text.toString().toInt() !in 0..150) {
                    Toast.makeText(applicationContext, "Возраст должен быть в диапазоне от 0 до 150", Toast.LENGTH_SHORT).show()
                    ViewCompat.setBackgroundTintList(age, errorColor)
                } else {
                    ViewCompat.setBackgroundTintList(age, defaultColor)
                }
            }
        })


        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (name.text.isEmpty() || height.text.isEmpty() || weight.text.isEmpty() || age.text.isEmpty()) {
                    result.text = "Данные введены некорректно."
                    return
                }

                var heightValue = height.text.toString().toInt()
                var weightValue = weight.text.toString().toDouble()
                var ageValue = age.text.toString().toInt()

                if (heightValue !in 0..250 || weightValue !in 0.0..250.0 || ageValue !in 0..150) {
                    result.text = "Данные введены некорректно."
                } else {
                    result.text =
                        "Ответ: " + (heightValue * 19 + weightValue * 31 + ageValue * 37 + name.text.length * 997)
                }
            }
        })
    }
}