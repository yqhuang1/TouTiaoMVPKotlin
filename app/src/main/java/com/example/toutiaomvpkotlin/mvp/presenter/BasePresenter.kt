package com.example.toutiaomvpkotlin.mvp.presenter

import com.example.toutiaomvpkotlin.mvp.view.BaseView

open class BasePresenter<V> {
    private var mBaseView: V? = null

    fun bindView(mBaseView: V) {
        this.mBaseView = mBaseView
    }

    fun unBindView() {
        this.mBaseView = null
    }

    fun getBaseView() = mBaseView
}