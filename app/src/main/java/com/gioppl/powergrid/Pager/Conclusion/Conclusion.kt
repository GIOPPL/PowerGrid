package com.gioppl.powergrid.Pager.Conclusion

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.TextView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.ConclusionEntity
import com.gioppl.powergrid.present.ConclusionPresent
import com.gioppl.powergrid.view.ConclusionView
import com.song.refresh_view.PullToRefreshView
import java.util.*


/**
 * Created by GIOPPL on 2017/7/24.
 */
class Conclusion : Fragment(), ConclusionView {
    //图片
    //    var lin_light:LinearLayout?=null//光照
    //    var lin_time:LinearLayout?=null//运行时间
    //    var lin_power:LinearLayout?=null//总节能
    //    var lin_temperature:LinearLayout?=null//温度
    //    var lin_warning:LinearLayout?=null//报警
    //    var lin_equipment:LinearLayout?=null//设备总数
    //    var im_light: ImageView? = null
    var present: ConclusionPresent? = null

    var mRefreshView: PullToRefreshView? = null//下拉刷新控件

    var fim_head: SimpleDraweeView? = null//动态图

    //gif图中的数据
    var tv_GFZGL: TextView? = null
    var tv_CNZGL: TextView? = null
    var tv_FZZGL: TextView? = null
    var tv_LLXZGL: TextView? = null

    //轮播图

    //数据
    var tv_temperature:TextView?=null
    var tv_light:TextView?=null
    var tv_warning:TextView?=null
    var tv_totalPower:TextView?=null
    var tv_model:TextView?=null
    var tv_power:TextView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.one, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initGif()
        initRollImage()
        present = ConclusionPresent((activity as Context?)!!)
        present!!.onCreate()
        present!!.getData(this)
        //开启一个主动刷新的线程
        refreshThread()
    }

    private fun initRollImage() {

    }


    private fun refreshThread() {
        Thread(Runnable {
            while (true) {
                Thread(Runnable {
                    present!!.getData(this)
                }).start()
                Thread.sleep(10000)
            }

        }).start()

    }

    private fun initGif() {
        fim_head = activity.findViewById(R.id.fim_four_head) as SimpleDraweeView?
        val mDrawerController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                //加载drawable里的一张gif图
                .setUri(Uri.parse("res://drawable/" + R.drawable.power))//设置uri
                .build()
        fim_head!!.setController(mDrawerController)
        tv_CNZGL = activity.findViewById(R.id.tv_con_CNZGL) as TextView?
        tv_GFZGL = activity.findViewById(R.id.tv_con_GFZGL) as TextView?
        tv_FZZGL = activity.findViewById(R.id.tv_con_FZZGL) as TextView?
        tv_LLXZGL = activity.findViewById(R.id.tv_con_LLXZGL) as TextView?
    }

    private fun initView() {
//        im_light = activity.findViewById(R.id.im_main_light) as ImageView?
//        lin_light = activity.findViewById(R.id.lin_main_light) as LinearLayout?
//        lin_time = activity.findViewById(R.id.lin_main_time) as LinearLayout?
//        lin_power = activity.findViewById(R.id.lin_main_power) as LinearLayout?
//        lin_temperature = activity.findViewById(R.id.lin_main_temperature) as LinearLayout?
//        lin_warning = activity.findViewById(R.id.lin_main_warning) as LinearLayout?
//        lin_equipment = activity.findViewById(R.id.lin_main_equipment) as LinearLayout?

        tv_totalPower= activity.findViewById(R.id.tv_conclusion_totalPower) as TextView?
        tv_light= activity.findViewById(R.id.tv_conclusion_light) as TextView?
        tv_power= activity.findViewById(R.id.tv_conclusion_power) as TextView?
        tv_temperature= activity.findViewById(R.id.tv_conclusion_temper) as TextView?
        tv_model= activity.findViewById(R.id.tv_conclusion_model) as TextView?
        tv_warning= activity.findViewById(R.id.tv_conclusion_warning) as TextView?

        mRefreshView = activity.findViewById(R.id.refreshView_one) as PullToRefreshView?
        mRefreshView!!.setColorSchemeColors(Color.RED, Color.BLUE) // 颜色
        mRefreshView!!.setSmileStrokeWidth(8f) // 设置绘制的笑脸的宽度
        mRefreshView!!.setSmileInterpolator(LinearInterpolator()) // 笑脸动画转动的插值器
        mRefreshView!!.setSmileAnimationDuration(2000) // 设置笑脸旋转动画的时长
        //设置下拉刷新监听
        mRefreshView!!.setOnRefreshListener(PullToRefreshView.OnRefreshListener {
            present!!.getData(this)
        })
    }

    override fun onSuccess(mConclusionEntity: ConclusionEntity) {
        tv_CNZGL!!.text = "功率:" + mConclusionEntity.overview.cnzgl
        tv_FZZGL!!.text = "功率:" + mConclusionEntity.overview.fzzgl
        tv_GFZGL!!.text = "功率:" + mConclusionEntity.overview.gfzgl
        tv_LLXZGL!!.text = "功率:" + mConclusionEntity.overview.bwzgl

        tv_totalPower!!.text="总发电量:"+mConclusionEntity.overview.zfdl
        tv_model!!.text="模式:"+mConclusionEntity.overview.mode
        tv_temperature!!.text="温度:"+mConclusionEntity.overview.wd
        tv_power!!.text="日发电量:"+mConclusionEntity.overview.rfdl
        tv_light!!.text="光照:"+mConclusionEntity.overview.rz

        mRefreshView!!.isRefreshing = false
    }

    override fun onError(e: String) {
        //
    }

    override fun onPause() {
        super.onPause()
        present!!.onStop()
    }

    fun log(text: String) {
        Log.i("##", text)
    }

    class TimeUpdate(private val present: ConclusionPresent, private val view: ConclusionView) : TimerTask() {
        override fun run() {
            present.getData(view)
            Log.i("**", "1次")
        }
    }
}