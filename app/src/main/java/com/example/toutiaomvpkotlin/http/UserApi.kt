package com.example.toutiaomvpkotlin.http

import com.example.toutiaomvpkotlin.mvp.model.BaseModel
import com.example.toutiaomvpkotlin.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {
    @GET("index/appIndexList.html")
    fun getTest(): Observable<BaseModel<MainModel>>
}