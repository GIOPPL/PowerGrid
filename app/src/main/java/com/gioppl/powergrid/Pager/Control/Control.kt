package com.gioppl.powergrid.Pager.Control

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.getbase.floatingactionbutton.FloatingActionButton
import com.gioppl.powergrid.R
import com.gioppl.powergrid.function.PinchImageView

/**
 * Created by GIOPPL on 2017/7/24.
 */
class Control : Fragment(),View.OnClickListener {
    var show=1//偶数为显示控制界面，奇数为显示图片界面
    var mRV: RecyclerView?=null
    var mAdapt:ControlAdapt?=null
    var mList:ArrayList<ControlEquipmentBean> ?= ArrayList()
    var fbtn_image:FloatingActionButton?=null
    var pim_control: PinchImageView?=null
    var lin_control: LinearLayout?=null
    var layoutManager :GridLayoutManager?=null
    //四大菜单
    var tv_make:TextView?=null
    var tv_use:TextView?=null
    var tv_store: TextView?=null
    var tv_other:TextView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.control, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
        initRV()

    }

    private fun initView() {
        tv_make= activity.findViewById(R.id.tv_control_makeE) as TextView?
        tv_use= activity.findViewById(R.id.tv_control_useE) as TextView?
        tv_store= activity.findViewById(R.id.tv_control_storeE) as TextView?
        tv_other= activity.findViewById(R.id.tv_control_otherE) as TextView?
        //设置监听事件
        tv_make!!.setOnClickListener(this);
        tv_use!!.setOnClickListener(this);
        tv_store!!.setOnClickListener(this);
        tv_other!!.setOnClickListener(this);

        lin_control= activity.findViewById(R.id.lin_control) as LinearLayout?
        pim_control= activity.findViewById(R.id.pim_control) as PinchImageView?
        pim_control!!.visibility=View.GONE
        fbtn_image= activity.findViewById(R.id.fbtn_control_manageImage) as FloatingActionButton?
        fbtn_image!!.setIconDrawable(resources.getDrawable(R.drawable.photo))
        fbtn_image!!.setOnClickListener {
            if (show%2==0){//显示控制界面
                pim_control!!.visibility=View.GONE
                lin_control!!.visibility=View.VISIBLE
            }else{
                pim_control!!.visibility=View.VISIBLE
                lin_control!!.visibility=View.GONE
            }
            show++
        }

    }

    private fun initData() {
        var bean:ControlEquipmentBean?= ControlEquipmentBean()
        bean!!.name="A座行政楼"
        var beanList:ArrayList<ControlEquipmentBean.Equipment>?= ArrayList();
        beanList!!.add(ControlEquipmentBean.Equipment())
        beanList!!.add(ControlEquipmentBean.Equipment())
        beanList!!.add(ControlEquipmentBean.Equipment())
        bean.equipmentInfo=beanList
        for (x in 1..10)
            mList!!.add(bean)
    }

    //初始化recyclerView
    private fun initRV() {
        mRV= activity.findViewById(R.id.RV_control) as RecyclerView?
        mAdapt= ControlAdapt(mList!!,activity)
        layoutManager = GridLayoutManager(activity,1);//set hte number of column on this boundary
        mRV!!.setLayoutManager(layoutManager)
        layoutManager!!.orientation = OrientationHelper.VERTICAL
        mRV!!.adapter=mAdapt
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.tv_control_makeE -> mRV!!.scrollToPosition(1)
            R.id.tv_control_storeE -> mRV!!.scrollToPosition(3)
            R.id.tv_control_useE -> mRV!!.scrollToPosition(5)
            R.id.tv_control_otherE -> mRV!!.scrollToPosition(8)
        }
    }
}