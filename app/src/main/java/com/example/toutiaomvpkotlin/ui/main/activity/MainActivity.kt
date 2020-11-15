package com.example.toutiaomvpkotlin.ui.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.BaseActivity
import com.example.toutiaomvpkotlin.ui.main.model.TitleModel
import com.example.toutiaomvpkotlin.ui.main.presenter.MainPresenter
import com.example.toutiaomvpkotlin.ui.main.view.MainView
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        val titles = resources.getStringArray(R.array.title)
        val selectIds = resources.obtainTypedArray(R.array.select)
        val unSelectIds = resources.obtainTypedArray(R.array.unselect)
        for (i in titles.indices) {
            titleTabs.add(
                TitleModel(
                    titles[i],
                    unSelectIds.getResourceId(i, 0),
                    selectIds.getResourceId(i, 0)
                )
            )
        }
        ctl_home.setTabData(titleTabs)
        getPresenter()!!.getTest()
    }

    override fun initData() {

    }

    override fun createPresenter() = MainPresenter()

    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {

    }
}