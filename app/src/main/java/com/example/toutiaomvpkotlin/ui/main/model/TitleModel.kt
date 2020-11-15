package com.example.toutiaomvpkotlin.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

//data表示这是个数据的类型
data class TitleModel(val title: String, val select: Int, val unSelect: Int) : CustomTabEntity {
    override fun getTabUnselectedIcon(): Int = unSelect

    override fun getTabSelectedIcon(): Int = select

    override fun getTabTitle(): String = title
}