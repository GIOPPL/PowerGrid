package com.gioppl.powergrid.netWork

import com.gioppl.powergrid.bean.StatusEntity
import retrofit2.http.GET
import rx.Observable

/**
 * Created by GIOPPL on 2017/8/28.
 */
interface GetStatusData {
    @GET("statisticData.do")
    fun getData(): Observable<StatusEntity>
}