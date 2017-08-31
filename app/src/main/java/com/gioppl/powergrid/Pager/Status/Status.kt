package com.gioppl.powergrid.Pager.Status

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.gioppl.powergrid.R
import com.shinelw.library.ColorArcProgressBar
import com.song.refresh_view.PullToRefreshView

/**
 * Created by GIOPPL on 2017/7/24.
 */

class Status : Fragment(){
    var bar: ColorArcProgressBar?=null//总发电轮盘
    //下拉刷新
    var mRefreshView: PullToRefreshView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.status1, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()

    }


    private fun initView() {
        bar= activity.findViewById(R.id.bar_one) as ColorArcProgressBar?;
        bar!!.setCurrentValues(14998.77f)
        mRefreshView= activity.findViewById(R.id.refreshView_control) as PullToRefreshView?
        mRefreshView!!.setColorSchemeColors(Color.RED, Color.BLUE) // 颜色
        mRefreshView!!.setSmileStrokeWidth(8f) // 设置绘制的笑脸的宽度
        mRefreshView!!.setSmileInterpolator(LinearInterpolator()) // 笑脸动画转动的插值器
        mRefreshView!!.setSmileAnimationDuration(2000) // 设置笑脸旋转动画的时长
        //设置下拉刷新监听
        mRefreshView!!.setOnRefreshListener(PullToRefreshView.OnRefreshListener {
//            present!!.getData(this)
        })
    }
}
