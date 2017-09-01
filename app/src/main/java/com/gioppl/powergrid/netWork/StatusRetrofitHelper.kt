package com.gioppl.powergrid.netWork

import com.gioppl.powergrid.bean.StatusEntity
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by GIOPPL on 2017/8/25.
 */
class StatusRetrofitHelper {
    companion object {
        private val client=OkHttpClient()
        private val factory=GsonConverterFactory.create(GsonBuilder().create())
        private val mRetrofit=Retrofit.Builder()
                .baseUrl("http://192.168.1.132:8000/mnm/ar/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        fun getInstance():Observable<StatusEntity>{
            val cla=mRetrofit.create(GetStatusData::class.java)
            val cla2= cla.getData()
            return cla2
        }
    }

}