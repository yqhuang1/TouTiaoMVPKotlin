package com.example.toutiaomvpkotlin.ui.user.activity

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.BaseActivity
import com.example.toutiaomvpkotlin.ui.user.presenter.RegisterPresenter
import com.example.toutiaomvpkotlin.ui.user.view.RegisterView
import com.example.toutiaomvpkotlin.utils.CommonUtils.checkMobile
import com.example.toutiaomvpkotlin.utils.CommonUtils.replaceBlank
import com.example.toutiaomvpkotlin.view.MyCheckBox
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<RegisterView, RegisterPresenter>(), RegisterView,
    TextWatcher {
    override fun getLayoutId(): Int = R.layout.activity_register

    override fun initView() {
        cd_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_999999))
        my_cbox.setChecked(false)
        met_mobile.addTextChangedListener(this)
        btn_back.setOnClickListener {
            finish()
        }
        my_cbox.setOnClickListener {
            my_cbox.changeState()
            checkPhone()
        }
        my_cbox.setClickableSpanText(object : MyCheckBox.ClickableSpanText {
            override fun onClick(type: Int) {
                if (type == 1) {
                    Toast.makeText(application, "用户协议", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(application, "隐私协议", Toast.LENGTH_SHORT).show()
                }
            }

        })
        cd_next.setOnClickListener {
            if (TextUtils.isEmpty(phoneText)) {
                Toast.makeText(application, "请先填写电话", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!my_cbox.isChecked()) {
                Toast.makeText(application, "请先勾选协议", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // TODO: 2020/11/22  
        }
    }

    override fun initData() {

    }

    override fun createPresenter(): RegisterPresenter = RegisterPresenter()

    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {

    }

    private var phoneText: String = ""

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        phoneText = s.toString()
        checkPhone()
    }

    private fun checkPhone() {
        if (phoneText.length == 13 && my_cbox.isChecked() && checkMobile(replaceBlank(phoneText))) {
            cd_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_E6645F))
        } else {
            cd_next.setCardBackgroundColor(ContextCompat.getColor(this, R.color.c_222222))

        }
    }
}