package com.gioppl.powergrid.Pager.Status

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.TextView
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.StatusEntity
import com.gioppl.powergrid.present.StatusPresent
import com.gioppl.powergrid.view.StatusView
import com.shinelw.library.ColorArcProgressBar
import com.song.refresh_view.PullToRefreshView

/**
 * Created by GIOPPL on 2017/7/24.
 */

class Status : Fragment(),StatusView{

    var tv_everyE:TextView?=null
    var tv_allE:TextView?=null
    var tv_useE:TextView?=null

    var entity:StatusEntity?=null
    var present:StatusPresent?=null
    var bar: ColorArcProgressBar?=null//总发电轮盘
    //下拉刷新
    var mRefreshView: PullToRefreshView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.status1, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        present= StatusPresent(activity)
        present!!.onCreate()
        present!!.getData(this)
    }


    private fun initView() {
        tv_everyE= activity.findViewById(R.id.tv_status_every) as TextView?
        tv_allE= activity.findViewById(R.id.tv_status_all) as TextView?
        tv_useE= activity.findViewById(R.id.tv_status_use) as TextView?
        tv_everyE!!.setOnClickListener (){
            bar!!.setCurrentValues(java.lang.Float.valueOf(entity!!.statisticData[0].value))
            tv_everyE!!.setBackground(resources.getDrawable(R.drawable.tv_select_pressed))
            tv_allE!!.setBackground(resources.getDrawable(R.drawable.tv_select_normal))
            tv_useE!!.setBackground(resources.getDrawable(R.drawable.tv_select_normal))
        }
        tv_allE!!.setOnClickListener {
            bar!!.setCurrentValues(java.lang.Float.valueOf(entity!!.statisticData[1].value))
            tv_everyE!!.setBackground(resources.getDrawable(R.drawable.tv_select_normal))
            tv_allE!!.setBackground(resources.getDrawable(R.drawable.tv_select_pressed))
            tv_useE!!.setBackground(resources.getDrawable(R.drawable.tv_select_normal))
        }
        tv_useE!!.setOnClickListener {
            bar!!.setCurrentValues(java.lang.Float.valueOf(entity!!.statisticData[2].value))
            tv_everyE!!.setBackground(resources.getDrawable(R.drawable.tv_select_normal))
            tv_allE!!.setBackground(resources.getDrawable(R.drawable.tv_select_normal))
            tv_useE!!.setBackground(resources.getDrawable(R.drawable.tv_select_pressed))
        }

        bar= activity.findViewById(R.id.bar_one) as ColorArcProgressBar?
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

    override fun onSuccess(mEntity: StatusEntity) {
        entity=mEntity
        mRefreshView!!.isRefreshing=false//
        bar!!.setCurrentValues(java.lang.Float.valueOf(entity!!.statisticData[1].value))
    }

    override fun onError(e: String) {
        log("error:"+e)
        mRefreshView!!.isRefreshing=false
    }


    fun log(text:String){
        Log.i("control###",text)
    }
}
