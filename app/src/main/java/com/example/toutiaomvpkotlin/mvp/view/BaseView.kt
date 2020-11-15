package com.example.toutiaomvpkotlin.mvp.view

interface BaseView {
    //返回范型T
    fun <T> setData(data: T)

    fun setError(err: String)
}