package com.gioppl.powergrid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation

/**
 * Created by GIOPPL on 2017/8/21.
 */
class AppStart : AppCompatActivity() {
    var v:View?=null
//    var sim_startApp:SimpleDraweeView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        v=View.inflate(this,R.layout.app_start,null)
        setContentView(v)
//        sim_startApp= findViewById(R.id.sim_startApp) as SimpleDraweeView?
//        sim_startApp!!.setImageURI("res://mipmap/"+R.mipmap.app_start)
        initPager()
    }

    private fun initPager() {
        var ani=AlphaAnimation(0.9f,1.0f)
        ani.duration=1000
        v!!.startAnimation(ani)
        ani.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startApp()
            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })
    }

    private fun startApp() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}