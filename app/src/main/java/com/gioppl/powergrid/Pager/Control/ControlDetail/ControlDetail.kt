package com.gioppl.powergrid.Pager.Control.ControlDetail

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.ControlDetailEntity
import com.gioppl.powergrid.eventBus.ControlDetailEventBus
import com.gioppl.powergrid.present.ControlDetailPresent
import com.gioppl.powergrid.view.ControlDetailView
import com.song.refresh_view.PullToRefreshView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode



/**
 * Created by GIOPPL on 2017/8/28.
 */
class ControlDetail : AppCompatActivity(),ControlDetailView {

    var present:ControlDetailPresent?=null
    var name:EquipmentName?=null
    var eventBus: ControlDetailEventBus?=null//上一个界面传过来的数据
    //下拉刷新
    var mRefreshView: PullToRefreshView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.control_detail)
        EventBus.getDefault().register(this)
        initView()
    }

    private fun initView() {
        mRefreshView= findViewById(R.id.refreshView_controlDetail) as PullToRefreshView?
        mRefreshView!!.setColorSchemeColors(Color.RED, Color.BLUE) // 颜色
        mRefreshView!!.setSmileStrokeWidth(8f) // 设置绘制的笑脸的宽度
        mRefreshView!!.setSmileInterpolator(LinearInterpolator()) // 笑脸动画转动的插值器
        mRefreshView!!.setSmileAnimationDuration(2000) // 设置笑脸旋转动画的时长
        //设置下拉刷新监听
        mRefreshView!!.setOnRefreshListener(PullToRefreshView.OnRefreshListener {
            present!!.getData(this,formatMessage(eventBus!!.equName!!).toString()+eventBus!!.equNumber)
        })
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun helloEventBus(eventBus: ControlDetailEventBus) {
        this.eventBus=eventBus
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
        mRefreshView!!.isRefreshing=false
    }

    override fun onError(e: String) {
        log("onError"+e)
        mRefreshView!!.isRefreshing=false
    }


    fun log(text:String){
        Log.i("##ControlDetail2",text)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
        present!!.onStop()
    }

    override fun onStop() {
        super.onStop()
        present!!.onStop()
    }

    override fun onPause() {
        super.onPause()
        present!!.onStop()
    }

    public fun back(view:View){
        finish()
    }
}