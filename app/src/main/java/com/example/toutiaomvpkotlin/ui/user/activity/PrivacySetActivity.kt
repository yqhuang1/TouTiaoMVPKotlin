package com.example.toutiaomvpkotlin.ui.user.activity

import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.BaseActivity
import com.example.toutiaomvpkotlin.ui.user.presenter.PrivacySetPresenter
import com.example.toutiaomvpkotlin.ui.user.view.PrivacySetView
import kotlinx.android.synthetic.main.activity_privacy_set.*

class PrivacySetActivity : BaseActivity<PrivacySetView, PrivacySetPresenter>(), PrivacySetView {
    override fun getLayoutId(): Int = R.layout.activity_privacy_set

    override fun initView() {
        siv_h5.setBgSetItem(R.color.c_E6645F)
    }

    override fun initData() {

    }

    override fun createPresenter(): PrivacySetPresenter = PrivacySetPresenter()

    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {

    }
}