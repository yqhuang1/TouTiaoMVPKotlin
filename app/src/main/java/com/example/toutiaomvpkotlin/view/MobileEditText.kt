package com.example.toutiaomvpkotlin.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.example.toutiaomvpkotlin.R

class MobileEditText @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet?,
    defStyleAttr: Int = R.attr.editTextStyle
) :
    AppCompatEditText(context, attrs, defStyleAttr) {

    private var draw: Drawable? = null
    private var drawShow: Drawable? = null

    init {
//        draw = ContextCompat.getDrawable(context!!, R.mipmap.cancel_button)
        draw = context?.let { ContextCompat.getDrawable(it, R.mipmap.cancel_button) }
        val minimumWidth = draw!!.minimumWidth
        val minimumHeight = draw!!.minimumHeight
        draw!!.setBounds(0, 0, minimumWidth, minimumHeight)
        addTextChangedListener(TextWatcherEditText())
        isShow(false)
    }

    private fun isShow(isShow: Boolean) {
        drawShow = if (isShow) {
            draw
        } else {
            null
        }
        setCompoundDrawables(
            compoundDrawables[0],
            compoundDrawables[1],
            drawShow,
            compoundDrawables[3]
        )
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event!!.action == MotionEvent.ACTION_DOWN) {
            var isDelect =
                event.x > (width - totalPaddingRight) && event.x < (width - paddingRight) && event.y > 0 && event.y < height
            if (isDelect) {
                setText("")
            }
        }
        return super.onTouchEvent(event)
    }

    private inner class TextWatcherEditText : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (TextUtils.isEmpty(text.toString())) {
                isShow(false)
            } else {
                isShow(true)
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var testContent = s.toString()
            val length = testContent.length
            if (length == 4 || length == 9) {
                if (testContent.substring(length - 1) == " ") {
                    testContent = testContent.substring(0, length - 1)
                    setText(testContent)
                    setSelection(testContent.length)
                } else {
                    testContent = testContent.substring(
                        0,
                        length - 1
                    ) + " " + testContent.substring(length - 1)
                    setText(testContent)
                    setSelection(testContent.length)
                }
            }
        }

    }
}