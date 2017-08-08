package com.gioppl.powergrid.Pager.Status

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import com.gioppl.powergrid.R





/**
 * Created by GIOPPL on 2017/7/24.
 */

class Status : Fragment(){
    var fim_head: SimpleDraweeView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.four, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        fim_head!!.setImageURI("http://ac-ri5cfios.clouddn.com/oj3kcf4jRLz8s3IOJeQ3NWhCoOur6TXFpTluHGeV.png")
    }

    private fun initView() {
        fim_head= activity.findViewById(R.id.fim_four_head) as SimpleDraweeView?
    }
}
