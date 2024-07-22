package com.smartpay.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class RegularTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {
        try {
            applyCustomFont(context)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        try {
            applyCustomFont(context)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        try {
            applyCustomFont(context)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun applyCustomFont(context: Context) {
        try {
            val typeface = Typeface.createFromAsset(context.assets, "font/Roboto-Regular.ttf")
            setTypeface(typeface)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
