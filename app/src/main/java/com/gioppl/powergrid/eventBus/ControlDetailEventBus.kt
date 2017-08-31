package com.gioppl.powergrid.eventBus

/**
 * Created by GIOPPL on 2017/8/31.
 */
class ControlDetailEventBus {
    var equName:String?=null
    var equNumber:String?=null

    constructor(equName: String?, equNumber: String?) {
        this.equName = equName
        this.equNumber = equNumber
    }
}