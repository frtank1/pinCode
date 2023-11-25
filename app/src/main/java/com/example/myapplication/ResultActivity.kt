package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

enum class ButtonEvent() {
    SHARE,
    SENDTOMAIL,
    CALL,
    OPENCAMERA
}

class ResultActivity : AppCompatActivity() {

    lateinit var btnShare: Button
    lateinit var btnSendToMail: Button
    lateinit var btnCall: Button
    lateinit var btnOpenCamera: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btnShare = findViewById(R.id.btn_share)
        btnSendToMail = findViewById(R.id.btn_send_mail)
        btnCall = findViewById(R.id.btn_call)
        btnOpenCamera = findViewById(R.id.btn_open_camera)

        btnShare.setOnClickListener {
            pushIntent(ButtonEvent.SHARE)
        }

        btnSendToMail.setOnClickListener {
            pushIntent(ButtonEvent.SENDTOMAIL)
        }

        btnCall.setOnClickListener {
            pushIntent(ButtonEvent.CALL)
        }

        btnOpenCamera.setOnClickListener {
            pushIntent(ButtonEvent.OPENCAMERA)
        }

    }

    private fun pushIntent(event: ButtonEvent) {

        when (event) {
            ButtonEvent.SHARE -> {
                val intent = Intent(Intent.ACTION_SEND);
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_TEXT, "ПРИВЕТ")
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Поделится через"))
                } else {
                    Toast.makeText(
                        this,
                        "Нет подходящего приложения для камеры",
                        Toast.LENGTH_SHORT
                    ).show();
                }

            }

            ButtonEvent.SENDTOMAIL -> {
                val intent = Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Поделится через"))
                } else {
                    Toast.makeText(
                        this,
                        "Нет подходящего приложения",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }

            ButtonEvent.CALL -> {
                val intent = Intent(Intent.ACTION_DIAL)
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Нет подходящего приложения",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }

            ButtonEvent.OPENCAMERA -> {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Нет подходящего приложения для камеры",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }
        }
    }
}