package com.example.toutiaomvpkotlin.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.toutiaomvpkotlin.R
import com.example.toutiaomvpkotlin.base.Constants.COMMON_BAR
import com.example.toutiaomvpkotlin.mvp.presenter.BasePresenter
import com.example.toutiaomvpkotlin.mvp.view.BaseView
import com.example.toutiaomvpkotlin.utils.StatusBarUtils

//MVP封装
//写成抽象类就不用实现BaseView的方法
abstract class BaseActivity<V, P : BasePresenter<V>> : AppCompatActivity(), BaseView {
    private var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        StatusBarUtils.setStatusBar(this, COMMON_BAR, R.color.c_FFFFFF)
        if (mPresenter == null) {
            mPresenter = createPresenter() as P
        }
        mPresenter!!.bindView(this as V)
        initView()
        initData()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun createPresenter(): P

    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }
}