package com.gioppl.powergrid.Pager.Control

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gioppl.powergrid.R

/**
 * Created by GIOPPL on 2017/7/24.
 */
class Control : Fragment() {
    var mRV: RecyclerView?=null
    var mAdapt:ControlAdapt?=null
    var mList:ArrayList<ControlEquipmentBean> ?= ArrayList()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.control, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
        initRV()

    }

    private fun initData() {
        var bean:ControlEquipmentBean?= ControlEquipmentBean()
        bean!!.name="逆变器"
        var beanList:ArrayList<ControlEquipmentBean.Equipment>?= ArrayList();
        beanList!!.add(ControlEquipmentBean.Equipment())
        beanList!!.add(ControlEquipmentBean.Equipment())
        beanList!!.add(ControlEquipmentBean.Equipment())
        bean.equipmentInfo=beanList
        mList!!.add(bean)
        mList!!.add(bean)
        mList!!.add(bean)
        mList!!.add(bean)
        mList!!.add(bean)
        mList!!.add(bean)
        mList!!.add(bean)
        mList!!.add(bean)
    }

    //初始化recyclerView
    private fun initRV() {
        mRV= activity.findViewById(R.id.RV_control) as RecyclerView?
        mAdapt= ControlAdapt(mList!!,activity)
        val layoutManager = GridLayoutManager(activity,1);//set hte number of column on this boundary
        mRV!!.setLayoutManager(layoutManager)
        layoutManager.orientation = OrientationHelper.VERTICAL
        mRV!!.setAdapter(mAdapt)
    }
}