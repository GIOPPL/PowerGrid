package com.gioppl.powergrid.netWork

import com.gioppl.powergrid.bean.ControlDetailEntity
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by GIOPPL on 2017/8/25.
 */
interface GetControlDetailData {
    @GET("deviceData.do")
    fun getData(@Query("deviceCode") name:String): Observable<ControlDetailEntity>
}