package com.example.toutiaomvpkotlin.ui.main.activity

import androidx.fragment.app.Fragment
import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.BaseActivity
import com.example.toutiaomvpkotlin.base.Constants.HOME_BAR
import com.example.toutiaomvpkotlin.ui.main.adapter.HomeAdapter
import com.example.toutiaomvpkotlin.ui.main.fragment.HomeFragment
import com.example.toutiaomvpkotlin.ui.main.fragment.MinVideoFragment
import com.example.toutiaomvpkotlin.ui.main.fragment.MineFragment
import com.example.toutiaomvpkotlin.ui.main.fragment.VideoFragment
import com.example.toutiaomvpkotlin.ui.main.model.TitleModel
import com.example.toutiaomvpkotlin.ui.main.presenter.MainPresenter
import com.example.toutiaomvpkotlin.ui.main.view.MainView
import com.example.toutiaomvpkotlin.utils.StatusBarUtils
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        StatusBarUtils.setStatusBar(this, HOME_BAR, R.color.c_E6645F)
        val titles = resources.getStringArray(R.array.title)
        val selectIds = resources.obtainTypedArray(R.array.select)
        val unSelectIds = resources.obtainTypedArray(R.array.unselect)
        for (i in titles.indices) {
            titleTabs.add(
                TitleModel(
                    titles[i],
                    selectIds.getResourceId(i, 0),
                    unSelectIds.getResourceId(i, 0)
                )
            )
        }
        fragments.add(HomeFragment())
        fragments.add(VideoFragment())
        fragments.add(MinVideoFragment())
        fragments.add(MineFragment())
        vp_home.adapter = HomeAdapter(supportFragmentManager, fragments)
        vp_home.offscreenPageLimit = fragments.size
        ctl_home.setTabData(titleTabs)
        ctl_home.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                vp_home.setCurrentItem(position, false)
            }

            override fun onTabReselect(position: Int) {

            }

        })
//        getPresenter()!!.getTest()
    }

    override fun initData() {

    }

    override fun createPresenter() = MainPresenter()

    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {

    }
}