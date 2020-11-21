package com.example.toutiaomvpkotlin.view

import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.toutiaomvpkotlin.R
import kotlinx.android.synthetic.main.my_checkbox.view.*

class MyCheckBox @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
) :
    FrameLayout(context, attrs, defStyleAttr) {
    private var isChecked = false
    private var isSelected = R.mipmap.checkbox_pressed
    private var isUnSelected = R.mipmap.checkbox_normal
    private var mClickableSpanText: ClickableSpanText? = null

    init {
        /**
         * 加载布局，才可以把写的布局加载进来
         * @param context:上下文
         * @param resource:自定义布局
         * @param root:ViewGroup，根布局，当前布局
         * **/
        View.inflate(context, R.layout.my_checkbox, this)
        initSpan()
    }

    private fun initSpan() {
        val span = SpannableString(resources.getString(R.string.register_agreement))
        span.setSpan(object : ClickableSpan() {
            // 点击，调用监听接口方法
            override fun onClick(widget: View) {
                mClickableSpanText!!.onClick(1)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(context, R.color.c_222222)
                ds.isUnderlineText = false
            }
        }, 7, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        span.setSpan(object : ClickableSpan() {
            // 点击，调用监听接口方法
            override fun onClick(widget: View) {
                mClickableSpanText!!.onClick(2)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ContextCompat.getColor(context, R.color.c_222222)
                ds.isUnderlineText = false
            }
        }, 15, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.movementMethod = LinkMovementMethod.getInstance()
        text.highlightColor = Color.TRANSPARENT
        text.text = span
    }

    fun changeState() {
        isChecked = !isChecked
        if (isChecked) {
            image.setImageResource(isSelected)
        } else {
            image.setImageResource(isUnSelected)
        }
    }

    fun isChecked(): Boolean = isChecked

    fun setChecked(isCheck: Boolean) {
        this.isChecked = isChecked
        if (isChecked) {
            image.setImageResource(isSelected)
        } else {
            image.setImageResource(isUnSelected)
        }
    }

    interface ClickableSpanText {
        fun onClick(type: Int)
    }

    fun setClickableSpanText(ClickableSpanText: ClickableSpanText) {
        this.mClickableSpanText = mClickableSpanText
    }
}