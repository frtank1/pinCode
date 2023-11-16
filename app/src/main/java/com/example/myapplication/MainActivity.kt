package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textCode: TextView = findViewById(R.id.txt_code)

        val oneButton: Button = findViewById(R.id.number_1)
        val twoButton: Button = findViewById(R.id.number_2)
        val threeButton: Button = findViewById(R.id.number_3)
        val fourButton: Button = findViewById(R.id.number_4)
        val fiveButton: Button = findViewById(R.id.number_5)
        val sixButton: Button = findViewById(R.id.number_6)
        val sevenButton: Button = findViewById(R.id.number_7)
        val eightButton: Button = findViewById(R.id.number_8)
        val nineButton: Button = findViewById(R.id.number_9)
        val zeroButton: Button = findViewById(R.id.number_0)
        val deleteButton: Button = findViewById(R.id.btn_delete)
        val okButton: Button = findViewById(R.id.btn_ok)

        oneButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 1).toString()

            textCode.text = newText
        }

        twoButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 2).toString()

            textCode.text = newText
        }

        threeButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 3).toString()

            textCode.text = newText
        }

        fourButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 4).toString()

            textCode.text = newText
        }

        fiveButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 5).toString()

            textCode.text = newText
        }

        sixButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 6).toString()

            textCode.text = newText
        }

        sevenButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 7).toString()

            textCode.text = newText
        }

        eightButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 8).toString()

            textCode.text = newText
        }

        nineButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10 + 9).toString()

            textCode.text = newText
        }

        deleteButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() / 10).toString()

            // Изменить текст в TextView
            textCode.text = newText
            checkText(textCode)
        }

        zeroButton.setOnClickListener {
            checkText(textCode)
            val currentText = textCode.text.toString()
            val newText = (currentText.toInt() * 10).toString()

            // Изменить текст в TextView
            textCode.text = newText
        }

        okButton.setOnClickListener {
            val currentText = textCode.text.toString()
            if (currentText.toInt() == 1567) {
                Toast.makeText(this, getString(R.string.code_true), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.not_true), Toast.LENGTH_SHORT).show()

            }
        }

    }
}

fun checkText(textView: TextView){
    if (textView.text == "Введите код!") {
        val newText = 0
        textView.text = newText.toString()
    }else if(textView.text == "0"){
        textView.text = "Введите код!"
    }
}
