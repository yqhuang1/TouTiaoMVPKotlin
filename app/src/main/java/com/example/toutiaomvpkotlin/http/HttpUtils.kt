package com.example.toutiaomvpkotlin.http

import com.example.toutiaomvpkotlin.base.Constants.BASE_URL
import com.example.toutiaomvpkotlin.base.Constants.BASE_URL_TEST
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//类class改成object，意思是这类里面的所有方法和常量都是静态的
object HttpUtils {

    private var mOkHttp: OkHttpClient? = null

    private fun isTest(isTest: Boolean): String = if (isTest) BASE_URL_TEST else BASE_URL

    fun <T> createApi(clazz: Class<T>): T = Retrofit.Builder()
        .baseUrl(isTest(true))
        .client(getClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//适配器
        .addConverterFactory(GsonConverterFactory.create())//解析工厂
        .build().create(clazz)

    private fun getClient(): OkHttpClient? {
        if (mOkHttp == null) {
            mOkHttp = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
        }
        return mOkHttp
    }

    //拦截器，拦截一下日志
    private fun getInterceptor(): Interceptor {
        HttpLoggingInterceptor.Logger {
            Logger.json(it)
        }
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    //为外部提供一个构建http请求的方法
    //将泛型写在方法前面，让方法携带一下
    /**
     * @param:observable 被观察者
     * @param:Observer 观察者
     * */
    fun <T> sendHttp(observable: Observable<T>, listener: ResponseListener<T>) {
        observable.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<T> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: T) {
                    listener!!.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    listener!!.onFail(e.message.toString())
                }

            })
    }
}
