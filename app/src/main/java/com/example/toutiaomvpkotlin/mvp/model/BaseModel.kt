package com.example.toutiaomvpkotlin.mvp.model

//传入携带泛型T
data class BaseModel<T>(val code: Int, val message: String, val data: T)