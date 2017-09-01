package com.gioppl.powergrid

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.gioppl.powergrid.Pager.Conclusion.Conclusion
import com.gioppl.powergrid.Pager.Control.Control
import com.gioppl.powergrid.Pager.Data.Three
import com.gioppl.powergrid.Pager.SlidingDrawer
import com.gioppl.powergrid.Pager.Status.Status
import com.gioppl.powergrid.function.BanSliding
import com.yarolegovich.slidingrootnav.SlideGravity
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder

class MainActivity : FragmentActivity()  {


    var mRadioGroup: RadioGroup? = null
    var viewPager: BanSliding? = null
    var mPagerList = ArrayList<Fragment>()
    var mSliding:SlidingRootNav ? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        initView()
        initPager()
        initSlidingDrawer()
        SlidingDrawer(this)
    }

    private fun initSlidingDrawer() {
        mSliding=SlidingRootNavBuilder(this)
                .withMenuLayout(R.layout.sliding_drawer)
                .withMenuOpened(false) //Initial menu opened/closed state. Default == false
                .withMenuLocked(false) //If true, a user can't open or close the menu. Default == false.
                .withGravity(SlideGravity.LEFT) //If LEFT you can swipe a menu from left to right, if RIGHT - the direction is opposite.
                .inject();
    }

    private fun initView() {
        mRadioGroup = findViewById(R.id.rg_main_bottom) as RadioGroup?
        mRadioGroup!!.check(0)
        mRadioGroup!!.setOnCheckedChangeListener {
            radioGroup, i ->
            when (i) {
                R.id.rbtn_main_one -> viewPager!!.setCurrentItem(0)
                R.id.rbtn_main_two -> viewPager!!.setCurrentItem(1)
                R.id.rbtn_main_three -> viewPager!!.setCurrentItem(2)
                R.id.rbtn_main_four -> viewPager!!.setCurrentItem(3)
            }
        }

    }

    private fun initPager() {
        viewPager = findViewById(R.id.viewpager) as BanSliding?
        mPagerList.add(Conclusion())
        mPagerList.add(Control())
        mPagerList.add(Three())
        mPagerList.add(Status())
        var pagerAdapt = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment = mPagerList.get(position)
            override fun getCount(): Int = mPagerList.size
        }
        viewPager!!.adapter = pagerAdapt

    }

    private fun toast(text: String): Unit {
        Toast.makeText(this@MainActivity, "" + text, Toast.LENGTH_SHORT).show()
    }
    public fun back(view:View){
        mSliding!!.openMenu()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        log(event!!.x.toString()+","+event.y.toString())
        return super.onTouchEvent(event)
    }
    fun log(text:String){
        Log.i("##",text)
    }
    public fun aboutMe(view:View){
        startActivity(Intent(this@MainActivity,AboutMe::class.java))
    }


//    override fun onNetworkConnected(type: NetUtils.NetType) {
//        Alerter.create(this)
//                .setTitle("网络已连接")
//                .setText("连接正常")
//                .setBackgroundColorRes(R.color.colorAccent) // or setBackgroundColorInt(Color.CYAN)
//                .show();
//    }
//
//    override fun onNetworkDisConnected() {
//        Alerter.create(this)
//                .setTitle("网络断啦")
//                .setText("请检查网络")
//                .setBackgroundColorRes(R.color.colorAccent) // or setBackgroundColorInt(Color.CYAN)
//                .show();
//    }
}
