package com.gioppl.powergrid.netWork

import com.gioppl.powergrid.bean.ConclusionEntity
import retrofit2.http.GET
import rx.Observable

/**
 * Created by GIOPPL on 2017/8/25.
 */
interface GetConclusionData {
    @GET("overView.do")
    fun getData(): Observable<ConclusionEntity>
}