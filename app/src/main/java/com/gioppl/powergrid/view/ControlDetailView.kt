package com.gioppl.powergrid.view

import com.gioppl.powergrid.bean.ControlDetailEntity

/**
 * Created by GIOPPL on 2017/8/31.
 */
interface ControlDetailView {
    fun onSuccess(entity: ControlDetailEntity)
    fun onError(e:String)
}