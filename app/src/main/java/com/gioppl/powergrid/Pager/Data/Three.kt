package com.gioppl.powergrid.Pager.Data

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.OrientationHelper
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gioppl.powergrid.R
import com.gioppl.powergrid.adapt.ThreeAdapt
import com.gioppl.powergrid.bean.EquipmentBean
import com.github.jdsjlzx.recyclerview.LRecyclerView
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter

/**
 * Created by GIOPPL on 2017/7/24.
 */
class Three : Fragment() {
    var mRV:LRecyclerView?=null
    var mList=ArrayList<EquipmentBean>()
    var mLRecyclerAdapt: LRecyclerViewAdapter?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.three, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRV()
        mList.clear();
        mList.add(EquipmentBean("汇流器1","http://ac-qzlvbisn.clouddn.com/6044f5ddb81dad44dc00.png"))
        mList.add(EquipmentBean("汇流器2","http://ac-qzlvbisn.clouddn.com/6044f5ddb81dad44dc00.png"))
        mList.add(EquipmentBean("汇流器3","http://ac-qzlvbisn.clouddn.com/6044f5ddb81dad44dc00.png"))
        mList.add(EquipmentBean("汇流器4","http://ac-qzlvbisn.clouddn.com/6044f5ddb81dad44dc00.png"))
    }

    private fun initRV() {
        mRV= activity.findViewById(R.id.LRV_three) as LRecyclerView?
        var adapt=ThreeAdapt(mList,activity)
        mLRecyclerAdapt= LRecyclerViewAdapter(adapt)
        val layoutManager = GridLayoutManager(activity,3);//set hte number of column on this boundary
        mRV!!.setLayoutManager(layoutManager)
        layoutManager.orientation = OrientationHelper.VERTICAL
        mRV!!.setAdapter(mLRecyclerAdapt)
    }

}