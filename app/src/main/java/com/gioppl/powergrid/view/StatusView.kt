package com.gioppl.powergrid.view

import com.gioppl.powergrid.bean.StatusEntity

/**
 * Created by GIOPPL on 2017/8/25.
 */
interface StatusView {
    fun onSuccess(mEntity: StatusEntity)
    fun onError(e:String)
}