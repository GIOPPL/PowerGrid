package com.gioppl.powergrid.netWork

import com.gioppl.powergrid.bean.ControlEntity
import retrofit2.http.GET
import rx.Observable

/**
 * Created by GIOPPL on 2017/8/28.
 */
interface GetControlData {
    @GET("deviceView.do")
    fun getData(): Observable<ControlEntity>
}