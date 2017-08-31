package com.gioppl.powergrid.netWork

import com.gioppl.powergrid.bean.ControlDetailEntity
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by GIOPPL on 2017/8/25.
 */
class ControlDetailRetrofitHelper {
    companion object {
        private val client=OkHttpClient()
        private val factory=GsonConverterFactory.create(GsonBuilder().create())
        private val mRetrofit=Retrofit.Builder()
                .baseUrl("http://192.168.1.132:8000/mnm/ar/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        fun getInstance(equName:String):Observable<ControlDetailEntity>{
            val cla=mRetrofit.create(GetControlDetailData::class.java)
            val cla2= cla.getData(equName)
            return cla2
        }
    }

}