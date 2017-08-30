package com.gioppl.powergrid.Pager.Control

import android.app.Activity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.gioppl.powergrid.R


/**
 * Created by GIOPPL on 2017/8/8.
 */
class ControlAdapt2(mList: ArrayList<ControlEquipmentBean2>, activity: Activity) : RecyclerView.Adapter<ControlAdapt2.MyViewHolder>() {
    var mList: ArrayList<ControlEquipmentBean2>? = null
    private var activity: Activity? = null

    init {
        this.activity = activity
        this.mList = mList;
    }


    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder!!.tv_place!!.text=mList!![position].name
    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tv_place: TextView? = null

        init {
            initRV(itemView)
        }

        //初始化recyclerView
        private fun initRV(itemView: View?) {
            tv_place = itemView!!.findViewById(R.id.tv_controlItem_place) as TextView?
            val mRV = itemView.findViewById(R.id.RV_control_item) as RecyclerView
            val mAdapt = ControlItemAdapt(activity!!, mList!![0].equipmentInfo)
            val layoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.HORIZONTAL)
            mRV.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.HORIZONTAL));
            mRV.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL));
            mRV.layoutManager = layoutManager
            mRV.adapter = mAdapt
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = MyViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.control_item2, parent, false))

    override fun getItemCount() = mList!!.size
}