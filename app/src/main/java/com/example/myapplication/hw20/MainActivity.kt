package com.example.myapplication.hw20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    val KEY_TEXT: String = "TEXTCODE"
    val ID_COLOR: String = "IDCOLOR"
    lateinit var textCode: BoxTextGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_hw20)

        textCode = findViewById(R.id.txt_code_box)

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
           textCode.setIntoBox(1)
        }

        twoButton.setOnClickListener {
            textCode.setIntoBox(2)
        }

        threeButton.setOnClickListener {
            textCode.setIntoBox(3)
        }

        fourButton.setOnClickListener {
            textCode.setIntoBox(4)
        }

        fiveButton.setOnClickListener {
            textCode.setIntoBox(5)
        }

        sixButton.setOnClickListener {
            textCode.setIntoBox(6)
        }

        sevenButton.setOnClickListener {
            textCode.setIntoBox(7)
        }

        eightButton.setOnClickListener {
            textCode.setIntoBox(8)
        }

        nineButton.setOnClickListener {
            textCode.setIntoBox(9)
        }

        deleteButton.setOnClickListener {
            textCode.remove()
        }

        zeroButton.setOnClickListener {
            textCode.setIntoBox(0)
        }


        okButton.setOnClickListener {
            if(textCode.getCheck()) {
                    Toast.makeText(this, getString(R.string.code_true), Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ResultActivity::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this, getString(R.string.not_true), Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

