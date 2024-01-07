package com.example.myapplication.hw20

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.myapplication.R


private const val COLOR_NONE = -1
private const val COLOR_TRUE = 1
private const val COLOR_FALSE = 0
private var status = -1

class BoxText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int =0
): AppCompatTextView(context,attrs,defStyleAttr) {
    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BoxText,
            0, 0
        ).apply {
            try {
                status = getInt(R.styleable.BoxText_status, -1)
                updateBackground(status)
            } finally {
               recycle()
            }
        }
    }

    fun setBoxText(text: String) {
        setText(text)
    }


    fun setInputResult(int:Int) {
        status = int
        updateBackground(status)
    }

    private fun updateBackground(status: Int) {
        when (status) {
            COLOR_FALSE -> setBackgroundResource(R.drawable.shape_pressed)
            COLOR_TRUE -> setBackgroundResource(R.drawable.shape)
            COLOR_NONE -> setBackgroundResource(R.drawable.shape_default)
        }
    }
}