package com.example.toutiaomvpkotlin.ui.main.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.BaseFragment
import com.example.toutiaomvpkotlin.ui.main.presenter.HomePresenter
import com.example.toutiaomvpkotlin.ui.main.presenter.MinePresenter
import com.example.toutiaomvpkotlin.ui.main.view.MineView
import com.example.toutiaomvpkotlin.ui.user.activity.RegisterActivity
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment<MineView, MinePresenter>(), MineView {
    override fun getLayoutId(): Int = R.layout.fragment_mine

    override fun initView() {
        bt_register.setOnClickListener {
            val intent = Intent(activity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initData() {
    }

    override fun createPresenter(): MinePresenter = MinePresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }
}