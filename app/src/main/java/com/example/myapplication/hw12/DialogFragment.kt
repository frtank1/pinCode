package com.example.myapplication.hw12

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar


class MyDialogFragment : DialogFragment() {
    lateinit var onButtonDialogClickListener: OnButtonDialogClickListener
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = layoutInflater.inflate(R.layout.fragment_dialog, null, false)
        val dialog = AlertDialog.Builder(requireActivity()).apply {
            setView(view)
        }.create()
        with(view) {
            findViewById<Button>(R.id.closeButton).setOnClickListener {
                onButtonDialogClickListener.onButtonDismis()
                dialog.dismiss()
            }

            findViewById<Button>(R.id.deleteButton).setOnClickListener {
                onButtonDialogClickListener.onButtonDelete()

                dialog.dismiss()

            }
        }
        return dialog

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onButtonDialogClickListener = context as OnButtonDialogClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context должен реализовывать OnButtonClickListener")
        }
    }
}