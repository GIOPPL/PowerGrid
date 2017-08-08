package com.gioppl.powergrid.Pager.Control

/**
 * Created by GIOPPL on 2017/8/8.
 */
class ControlEquipmentBean {
    var name:String?="逆变器"
    var equipmentInfo:ArrayList<Equipment> = ArrayList()
    public class Equipment{
        var equName:String?="逆变器"
        var equInter:String?="interface"
        var open:String?="0"
        var imageUrl:String?="http://ac-ri5cfios.clouddn.com/oj3kcf4jRLz8s3IOJeQ3NWhCoOur6TXFpTluHGeV.png"
    }
}