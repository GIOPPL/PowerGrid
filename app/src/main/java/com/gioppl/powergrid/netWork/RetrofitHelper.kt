package com.gioppl.powergrid.netWork

import com.gioppl.powergrid.bean.ConclusionEntity
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by GIOPPL on 2017/8/25.
 */
class RetrofitHelper {
    companion object {
        private val client=OkHttpClient()
        private val factory=GsonConverterFactory.create(GsonBuilder().create())
        private val mRetrofit=Retrofit.Builder()
                .baseUrl("http://192.168.1.132:8000/mnm/ar/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        fun getInstance():Observable<ConclusionEntity>{
            val cla=mRetrofit.create(GetConclusionData::class.java)
            val cla2= cla.getData()
            return cla2
        }
    }

}