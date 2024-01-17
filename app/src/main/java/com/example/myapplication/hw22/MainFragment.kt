package com.example.myapplication.hw22

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.hw7to10pincode.ButtonEvent

class MainFragment : Fragment() {

    lateinit var btnShare: Button
    lateinit var btnSendToMail: Button
    lateinit var btnCall: Button
    lateinit var btnOpenCamera: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnShare = view.findViewById(R.id.btn_share)
        btnSendToMail = view.findViewById(R.id.btn_send_mail)
        btnCall = view.findViewById(R.id.btn_call)
        btnOpenCamera = view.findViewById(R.id.btn_open_camera)

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
                if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Поделится через"))
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Нет подходящего приложения для камеры",
                        Toast.LENGTH_SHORT
                    ).show();
                }

            }

            ButtonEvent.SENDTOMAIL -> {
                val intent = Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Поделится через"))
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Нет подходящего приложения",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }

            ButtonEvent.CALL -> {
                val intent = Intent(Intent.ACTION_DIAL)
                if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Нет подходящего приложения",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }

            ButtonEvent.OPENCAMERA -> {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Нет подходящего приложения для камеры",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }
        }
    }
}