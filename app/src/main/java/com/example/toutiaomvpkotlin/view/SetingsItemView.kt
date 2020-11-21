package com.example.toutiaomvpkotlin.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.toutiaomvpkotlin.R
import kotlinx.android.synthetic.main.item_setings_view.view.*
import java.util.zip.Inflater

class SetingsItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?, defStyleAttr: Int
) :
    FrameLayout(context, attrs, defStyleAttr) {
    private var leftTitle: String? = ""
    private var rightTitle: String? = ""
    private var contentTitle: String? = ""

    private var isShowButton: Boolean = false
    private var isShowImage: Boolean = false

    private var view: View? = null

    private val setingsArry: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.SetingsItem)

    init {
        // 在xml里面要设置的属性
        leftTitle = setingsArry.getString(R.styleable.SetingsItem_leftTitle)
        rightTitle = setingsArry.getString(R.styleable.SetingsItem_rightTitle)
        contentTitle = setingsArry.getString(R.styleable.SetingsItem_contentTitle)

        isShowButton = setingsArry.getBoolean(R.styleable.SetingsItem_isShowButton, false)
        isShowImage = setingsArry.getBoolean(R.styleable.SetingsItem_isShowImage, false)

        setingsArry.recycle()
        // 初始化布局
        initView()
    }

    private fun initView() {
        view = LayoutInflater.from(context).inflate(R.layout.item_setings_view, this)
        view!!.left_title.text = leftTitle
        view!!.right_title.text = rightTitle
        view!!.content_title.text = contentTitle
        isShowButn(view!!)
        isShowImage(view!!)
    }

    private fun isShowButn(view: View) {
        if (isShowButton) {
            view.btn_off.visibility = View.VISIBLE
        } else {
            view.btn_off.visibility = View.GONE
        }
    }

    private fun isShowImage(view: View) {
        if (isShowImage) {
            view.iv_right_back.visibility = View.VISIBLE
        } else {
            view.iv_right_back.visibility = View.GONE
        }
    }

    fun setBgSetItem(colorIds: Int) {
        view!!.rl_item.setBackgroundColor(ContextCompat.getColor(context, colorIds))
    }

}