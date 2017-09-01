package com.gioppl.powergrid.Pager

import android.support.v4.app.FragmentActivity
import com.facebook.drawee.view.SimpleDraweeView
import com.gioppl.powergrid.R

/**
 * Created by GIOPPL on 2017/8/18.
 */
class SlidingDrawer(private var activity: FragmentActivity) {
    var fim_head: SimpleDraweeView?=null
    init {
        initView()
    }

    private fun initView() {
        fim_head= activity.findViewById(R.id.fim_sliding_head) as SimpleDraweeView?
        fim_head!!.setImageURI("res://drawable/"+R.drawable.head)
    }
}