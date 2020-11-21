package com.example.toutiaomvpkotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.toutiaomvpkotlin.mvp.presenter.BasePresenter
import com.example.toutiaomvpkotlin.mvp.view.BaseView

abstract class BaseFragment<V, P : BasePresenter<V>> : Fragment(), BaseView {
    private var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (mPresenter == null) {
            mPresenter = createPresenter() as P
        }
        mPresenter!!.bindView(this as V)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //view = inflater.inflate(getLayoutId(), null)
        //view?.findViewById(R.id.tv_show) as TextView
        // Inflate the layout for this fragment
        return inflater.inflate(getLayoutId(), null)
    }

    // 获取控件操作在这个方法
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun createPresenter(): P

    fun getPresenter() = mPresenter

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }
}