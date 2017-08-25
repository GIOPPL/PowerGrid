package com.gioppl.powergrid.netWork

import android.graphics.Bitmap

/**
 * Created by GIOPPL on 2017/7/27.
 */
class OneNetWork (getData:getDataSuccessful){
    private var getData:getDataSuccessful?=null
    init {
        this.getData=getData
    }


    interface getDataSuccessful{
        fun success()
        fun downImage(response: Bitmap?)
    }
}