package com.cvgs.androidmodule1.homework.salvadorchavez.tarea1.utils

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.widget.EditText
import androidx.resourceinspection.annotation.Attribute
import com.cvgs.androidmodule1.R

//For empty EditTexts
fun EditText.markAsInvalid(){
    this.setBackgroundResource(R.drawable.rounded_edittext_error)
    this.setHintTextColor(context.getThemeColor(com.google.android.material.R.attr.colorError))
}

fun EditText.isNotFilled(): Boolean {
    return this.text.toString().trim().isEmpty()
}


fun EditText.resetOnTyping(){
    this.addTextChangedListener(object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            this@resetOnTyping.setBackgroundResource(R.drawable.rounded_edittext)
            this@resetOnTyping.setHintTextColor(Color.GRAY)
            this@resetOnTyping.setTextColor(context.getThemeColor(com.google.android.material.R.attr.colorOnBackground))
        }

        override fun afterTextChanged(s: Editable?) {}
    })
}

fun Context.getThemeColor(attr: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attr, typedValue, true)
    return typedValue.data
}