package com.example.toutiaomvpkotlin.ui.main.fragment

import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.BaseFragment
import com.example.toutiaomvpkotlin.ui.main.presenter.HomePresenter
import com.example.toutiaomvpkotlin.ui.main.presenter.VideoPresenter
import com.example.toutiaomvpkotlin.ui.main.view.HomeView
import com.example.toutiaomvpkotlin.ui.main.view.VideoView

class VideoFragment : BaseFragment<VideoView, VideoPresenter>() {
    override fun getLayoutId(): Int = R.layout.fragment_video

    override fun initView() {
    }

    override fun initData() {
    }

    override fun createPresenter(): VideoPresenter = VideoPresenter()

    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }
}