package com.gioppl.powergrid.view

import com.gioppl.powergrid.bean.ControlEntity

/**
 * Created by GIOPPL on 2017/8/25.
 */
interface ControlView {
    fun onSuccess(entity: ControlEntity)
    fun onError(e:String)
}