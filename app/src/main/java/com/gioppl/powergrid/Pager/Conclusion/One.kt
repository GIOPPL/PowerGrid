package com.gioppl.powergrid.Pager.Conclusion

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import com.gioppl.powergrid.R
import com.shinelw.library.ColorArcProgressBar
import com.song.refresh_view.PullToRefreshView



/**
 * Created by GIOPPL on 2017/7/24.
 */
class One : Fragment(){

    var im_light: ImageView?=null
    var bar: ColorArcProgressBar?=null//总发电轮盘
    var mRefreshView: PullToRefreshView?=null//下拉刷新控件
    var lin_light:LinearLayout?=null//光照
    var lin_time:LinearLayout?=null//运行时间
    var lin_power:LinearLayout?=null//总节能
    var lin_temperature:LinearLayout?=null//温度
    var lin_warning:LinearLayout?=null//报警
    var lin_equipment:LinearLayout?=null//设备总数
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.one, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
//        OneNetWork(object :getDataSuccessful {
//            override fun success() {
//
//            }
//
//            override fun downImage(response: Bitmap?) {
//                im_light!!.setImageBitmap(response)
//            }
//
//
//        })
    }

    private fun initView() {
        im_light= activity.findViewById(R.id.im_main_light) as ImageView?
        lin_light= activity.findViewById(R.id.lin_main_light) as LinearLayout?
        lin_time= activity.findViewById(R.id.lin_main_time) as LinearLayout?
        lin_power= activity.findViewById(R.id.lin_main_power) as LinearLayout?
        lin_temperature= activity.findViewById(R.id.lin_main_temperature) as LinearLayout?
        lin_warning= activity.findViewById(R.id.lin_main_warning) as LinearLayout?
        lin_equipment= activity.findViewById(R.id.lin_main_equipment) as LinearLayout?

        mRefreshView= activity.findViewById(R.id.refreshView_one) as PullToRefreshView?
        bar= activity.findViewById(R.id.bar_one) as ColorArcProgressBar?;
        mRefreshView!!.setColorSchemeColors(Color.RED, Color.BLUE) // 颜色
        mRefreshView!!.setSmileStrokeWidth(8f) // 设置绘制的笑脸的宽度
        mRefreshView!!.setSmileInterpolator(LinearInterpolator()) // 笑脸动画转动的插值器
        mRefreshView!!.setSmileAnimationDuration(2000) // 设置笑脸旋转动画的时长
        //设置下拉刷新监听
        mRefreshView!!.setOnRefreshListener(PullToRefreshView.OnRefreshListener {
            bar!!.setCurrentValues(14998.77f)
        })

    }

}