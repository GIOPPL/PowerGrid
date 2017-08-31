package com.gioppl.powergrid.Pager.Control.ControlDetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.ControlDetailEntity
import com.gioppl.powergrid.eventBus.ControlDetailEventBus
import com.gioppl.powergrid.present.ControlDetailPresent
import com.gioppl.powergrid.view.ControlDetailView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode



/**
 * Created by GIOPPL on 2017/8/28.
 */
class ControlDetail : AppCompatActivity(),ControlDetailView {

    var present:ControlDetailPresent?=null
    var name:EquipmentName?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.control_detail)
        EventBus.getDefault().register(this)
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun helloEventBus(eventBus: ControlDetailEventBus) {
        log(formatMessage(eventBus.equName!!).toString()+eventBus.equNumber)
        formatMessage(eventBus.equName!!)
        present=ControlDetailPresent(this)
        present!!.onCreate()
        present!!.getData(this,formatMessage(eventBus.equName!!).toString()+eventBus.equNumber)
    }

    /**
     * 解析数据
     * 如：逆变器02 1.2kW ->
     */
    fun formatMessage(name: String):EquipmentName{
        if (name.contains("逆变器")){
            return EquipmentName.NBJ
        }else if(name.contains("PCS")){
            return EquipmentName.PCS
        }else if(name.contains("DCDC")){
            return EquipmentName.DDC
        }else if(name.contains("锂电池")){
            return EquipmentName.LDC
        }else if(name.contains("超级电容")){
            return EquipmentName.SDC
        }else{
            return EquipmentName.其他
        }
    }

    //设备名字的枚举类
    //逆变器，PCS,超级电容，锂电池，双向DCDC
    enum class EquipmentName{
        NBJ,PCS,SDC,LDC,DDC,其他
    }

    override fun onSuccess(entity: ControlDetailEntity) {
        log("onSuccess"+entity.nbJ01.bj)
    }

    override fun onError(e: String) {
        log("onError"+e)
    }


    fun log(text:String){
        Log.i("##ControlDetail2",text)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}