package com.example.toutiaomvpkotlin.ui.main.presenter

import com.example.toutiaomvpkotlin.http.HttpUtils
import com.example.toutiaomvpkotlin.http.ResponseListener
import com.example.toutiaomvpkotlin.http.UserApi
import com.example.toutiaomvpkotlin.mvp.model.BaseModel
import com.example.toutiaomvpkotlin.mvp.presenter.BasePresenter
import com.example.toutiaomvpkotlin.ui.main.model.MainModel
import com.example.toutiaomvpkotlin.ui.main.view.MainView

class MainPresenter : BasePresenter<MainView>() {
    fun getTest() {
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(),
            object : ResponseListener<BaseModel<MainModel>> {
                override fun onSuccess(data: BaseModel<MainModel>) {
                    if (data != null) {
                        getBaseView()!!.setData(data)
                    }
                }

                override fun onFail(err: String) {
                    getBaseView()!!.setError(err)
                }

            })
    }
}