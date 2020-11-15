package com.example.toutiaomvpkotlin.http

interface ResponseListener<T> {
    fun onSuccess(data: T)
    fun onFail(err: String)
}