package com.gioppl.powergrid.Pager.Control

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.getbase.floatingactionbutton.FloatingActionButton
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.ControlEntity
import com.gioppl.powergrid.function.PinchImageView
import com.gioppl.powergrid.present.ControlPresent
import com.gioppl.powergrid.view.ControlView
import com.song.refresh_view.PullToRefreshView

/**
 * Created by GIOPPL on 2017/7/24.
 */
class Control : Fragment() , ControlView {
    var present: ControlPresent?=null
    var show=1//偶数为显示控制界面，奇数为显示图片界面
    var mRV: RecyclerView?=null
    var mAdapt: ControlAdapt?=null
    var mList:ArrayList<ControlEquipmentBean> ?= ArrayList()
    var fbtn_image:FloatingActionButton?=null
    var pim_control: PinchImageView?=null
    var layoutManager :GridLayoutManager?=null
    //下拉刷新
    var mRefreshView:PullToRefreshView?=null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.control, container, false)!!

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initRV()
        getData()
    }

    private fun getData() {
        present= ControlPresent(activity!!)
        present!!.onCreate()
        present!!.getData(this)
    }

    /**
     * 数据与整体架构的图片切换
     */
    private fun initView() {

        pim_control= activity.findViewById(R.id.pim_control) as PinchImageView?
        pim_control!!.visibility=View.GONE
        fbtn_image= activity.findViewById(R.id.fbtn_control_manageImage) as FloatingActionButton?
        fbtn_image!!.setIconDrawable(resources.getDrawable(R.drawable.photo))
        fbtn_image!!.setOnClickListener {
            if (show%2==0){//显示控制界面
                pim_control!!.visibility=View.GONE
            }else{
                pim_control!!.visibility=View.VISIBLE
            }
            show++
        }

        mRefreshView= activity.findViewById(R.id.refreshView_control) as PullToRefreshView?
        mRefreshView!!.setColorSchemeColors(Color.RED, Color.BLUE) // 颜色
        mRefreshView!!.setSmileStrokeWidth(8f) // 设置绘制的笑脸的宽度
        mRefreshView!!.setSmileInterpolator(LinearInterpolator()) // 笑脸动画转动的插值器
        mRefreshView!!.setSmileAnimationDuration(2000) // 设置笑脸旋转动画的时长
        //设置下拉刷新监听
        mRefreshView!!.setOnRefreshListener(PullToRefreshView.OnRefreshListener {
            present!!.getData(this)
        })
    }

    //初始化recyclerView
    private fun initRV() {
        mRV= activity.findViewById(R.id.rv_control) as RecyclerView?
        mAdapt= ControlAdapt(mList!!,activity)
        layoutManager = GridLayoutManager(activity,1);//set hte number of column on this boundary
        mRV!!.setLayoutManager(layoutManager)
        layoutManager!!.orientation = OrientationHelper.VERTICAL
        mRV!!.adapter=mAdapt
    }

    override fun onSuccess(entity: ControlEntity) {
        log("success")
        var bean: ControlEquipmentBean?= ControlEquipmentBean()
        //提娜佳光伏单元
        bean!!.name="光伏单元"
        var beanList:ArrayList<ControlEquipmentBean.Equipment>?= ArrayList();
        for (x in entity.gfdy){
            var a= ControlEquipmentBean.Equipment()
            a.equName=x.name+" "+x.value
            beanList!!.add(a)
        }
        bean.equipmentInfo=beanList!!
        mList!!.add(bean)


        //添加储能单元
        var bean2: ControlEquipmentBean?= ControlEquipmentBean()
        bean2!!.name="储能单元"
        var beanList2:ArrayList<ControlEquipmentBean.Equipment>?= ArrayList();
        for (x in entity.cndy){
            var a= ControlEquipmentBean.Equipment()
            a.equName=x.name+" "+x.value
            beanList2!!.add(a)
        }
        bean2.equipmentInfo=beanList2!!
        mList!!.add(bean2)

        //添加负载单元
        var bean3: ControlEquipmentBean?= ControlEquipmentBean()
        bean3!!.name="负载单元"
        var beanList3:ArrayList<ControlEquipmentBean.Equipment>?= ArrayList();
        for (x in entity.fzdy){
            var a= ControlEquipmentBean.Equipment()
            a.equName=x.name+" "+x.value
            beanList3!!.add(a)
        }
        bean3.equipmentInfo=beanList3!!
        mList!!.add(bean3)
        mAdapt!!.notifyDataSetChanged()
        mRefreshView!!.isRefreshing = false
    }

    override fun onError(e: String) {
        log("error:"+e)
    }

    override fun onPause() {
        super.onPause()
        present!!.onStop()
    }
    override fun onStop() {
        super.onStop()
        present!!.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        present!!.onStop()
    }

    fun log(text:String){
        Log.i("control###",text)
    }
}