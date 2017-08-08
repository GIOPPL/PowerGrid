package com.gioppl.powergrid.Pager.Data.ThreeDetail

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.EquipmentBean
import me.relex.circleindicator.CircleIndicator
import java.util.*

/**
 * Created by GIOPPL on 2017/7/24.
 */
class ThreeDetail : FragmentActivity() {
    private var indicator: CircleIndicator? = null//页数指示器
    var mPagerList: ArrayList<Fragment>? = null
    var vp: ViewPager? = null
    var bean: EquipmentBean? = null

    val mHander=object :Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg!!.arg1==0x1){
                Skip()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading)
        getData()
    }

    private fun Skip(){
        setContentView(R.layout.three_detail)
        ReceiveData()
        initView()
    }

    private fun getData() {
        val timer: Timer
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                System.out.println("Time's up!");
                var msg:Message= Message()
                msg!!.arg1=0x1
                mHander.sendMessage(msg)
                timer.cancel();
                
            }
        }, 3 * 1000);
    }

    private fun initView() {
        mPagerList = ArrayList()
        vp = findViewById(R.id.vp_threeDetail) as ViewPager?
        mPagerList!!.add(ThreeTwo())
        mPagerList!!.add(ThreeOne())
        var pagerAdapt = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment = mPagerList!!.get(position)
            override fun getCount(): Int = mPagerList!!.size
        }
        vp!!.adapter = pagerAdapt

        indicator = findViewById(R.id.indicator_threeDetail) as CircleIndicator?
        indicator!!.setViewPager(vp)
    }

    private fun ReceiveData() {
        val intent = this.intent
        bean = intent.getSerializableExtra("bean") as EquipmentBean
    }

    public fun back(view:View){
        finish();
    }

}