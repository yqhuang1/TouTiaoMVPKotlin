package com.example.toutiaomvpkotlin.ui.main.fragment

import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.BaseFragment
import com.example.toutiaomvpkotlin.ui.main.presenter.HomePresenter
import com.example.toutiaomvpkotlin.ui.main.presenter.MinVideoPresenter
import com.example.toutiaomvpkotlin.ui.main.view.MinVideoView

class MinVideoFragment : BaseFragment<MinVideoView, MinVideoPresenter>() {
    override fun getLayoutId(): Int = R.layout.fragment_min_video

    override fun initView() {
    }

    override fun initData() {
    }

    override fun createPresenter(): MinVideoPresenter = MinVideoPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }
}