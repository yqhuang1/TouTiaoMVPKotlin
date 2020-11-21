package com.example.toutiaomvpkotlin.ui.main.fragment

import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.BaseFragment
import com.example.toutiaomvpkotlin.ui.main.presenter.HomePresenter
import com.example.toutiaomvpkotlin.ui.main.view.HomeView

class HomeFragment : BaseFragment<HomeView, HomePresenter>() {
    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView() {

    }

    override fun initData() {

    }

    override fun createPresenter(): HomePresenter = HomePresenter()

    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {

    }
}