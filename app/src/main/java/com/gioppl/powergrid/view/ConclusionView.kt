package com.gioppl.powergrid.view

import com.gioppl.powergrid.bean.ConclusionEntity

/**
 * Created by GIOPPL on 2017/8/25.
 */
interface ConclusionView {
    fun onSuccess(mConclusionEntity: ConclusionEntity)
    fun onError(e:String)
}