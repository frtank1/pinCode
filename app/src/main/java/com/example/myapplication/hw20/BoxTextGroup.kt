package com.example.myapplication.hw20

import android.content.Context
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.LinearLayout
import com.example.myapplication.R

private var pin = arrayListOf<Int>()
private lateinit var box1: BoxText
private lateinit var box2: BoxText
private lateinit var box3: BoxText
private lateinit var box4: BoxText
private const val MAX = 4

class  BoxTextGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        val view = inflate(context, R.layout.box_group, this)
        box1 = view.findViewById<BoxText>(R.id.first_box)
        box2 = view.findViewById<BoxText>(R.id.second_box)
        box3 = view.findViewById<BoxText>(R.id.third_box)
        box4 = view.findViewById<BoxText>(R.id.fourth_box)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BoxTextGroup,
            0, 0
        ).apply {
            try {
                val pinCode = this.getInt(R.styleable.BoxTextGroup_pin, 0)
                setPin(pinCode)
            } finally {
                recycle()
            }
        }
    }

    private fun setPin(pinCode: Int) {
        val pinString = pinCode.toString()
        for (i in 0 until 4) {
            when (i) {
                0 -> box1.current(Character.getNumericValue(pinString[i]))
                1 -> box2.current(Character.getNumericValue(pinString[i]))
                2 -> box3.current(Character.getNumericValue(pinString[i]))
                3 -> box4.current(Character.getNumericValue(pinString[i]))
            }
        }
    }

    fun setIntoBox(temp: Int) {
        if (pin.size <= MAX) {
            pin.add(temp)
            when (pin.size) {
                1 -> box1.setBoxText(temp.toString())
                2 -> box2.setBoxText(temp.toString())
                3 -> box3.setBoxText(temp.toString())
                4 -> box4.setBoxText(temp.toString())
            }
        }
    }

    fun remove() {
        if (
            pin.size != 0
        ) {
            when (pin.size) {
                1 -> box1.setBoxText("")
                2 -> box2.setBoxText("")
                3 -> box3.setBoxText("")
                4 -> box4.setBoxText("")
            }
            pin.removeAt(pin.size - 1)
        }
    }

    fun getCheck():Boolean{
        var check = false
        check = check || box1.getCheck()
        check = check || box2.getCheck()
        check = check || box3.getCheck()
        check = check || box4.getCheck()
        return check
    }


}