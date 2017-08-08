package com.gioppl.powergrid.bean

import java.io.Serializable
/**
 * Created by GIOPPL on 2017/7/24.
 */
class EquipmentBean(name:String,url:String):Serializable{
    var name:String ?=name
    var url:String?=url
    var id:Int?=null
}