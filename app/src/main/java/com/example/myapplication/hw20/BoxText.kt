package com.example.myapplication.hw20

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.myapplication.R



class BoxText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int =0
): AppCompatTextView(context,attrs,defStyleAttr) {
    private  val COLOR_NONE = -1
    private  val COLOR_TRUE = 1
    private var current = -1
    private var status = -1
    private var check:Boolean = false

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
        if (text.isEmpty()){
            check = false
            updateBackground(COLOR_NONE)
        }else {
            val temp = text.toInt()
          if (current == temp){
            check = true
            updateBackground(COLOR_TRUE)
          }else{
              check = false
              updateBackground(Companion.COLOR_FALSE)
          }
        }
        setText(text)
    }


    fun setInputResult(int:Int) {
        status = int
        updateBackground(status)
    }

    private fun updateBackground(status: Int) {
        when (status) {
            Companion.COLOR_FALSE -> setBackgroundResource(R.drawable.shape_pressed)
            COLOR_TRUE -> setBackgroundResource(R.drawable.shape)
            COLOR_NONE -> setBackgroundResource(R.drawable.shape_default)
        }
    }

    fun getCheck():Boolean{
        return check
    }

     fun current(temp:Int){
        current = temp
    }

    companion object {
        private const val COLOR_FALSE = 0
    }
}