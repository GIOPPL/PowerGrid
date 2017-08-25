package com.gioppl.powergrid.Pager.Status

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gioppl.powergrid.R
import com.shinelw.library.ColorArcProgressBar

/**
 * Created by GIOPPL on 2017/7/24.
 */

class Status : Fragment(){
    var bar: ColorArcProgressBar?=null//总发电轮盘





    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.test, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()




    }

    private fun initView() {
        bar= activity.findViewById(R.id.bar_one) as ColorArcProgressBar?;
        bar!!.setCurrentValues(14998.77f)


    }
}
