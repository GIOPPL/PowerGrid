package com.gioppl.powergrid.base

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.caption.netmonitorlibrary.netStateLib.NetChangeObserver
import com.caption.netmonitorlibrary.netStateLib.NetStateReceiver
import com.caption.netmonitorlibrary.netStateLib.NetUtils


/**
 * Created by GIOPPL on 2017/9/1.
 */
abstract class BaseActivity : FragmentActivity() {
    /**
     * 网络观察者
     */
    protected var mNetChangeObserver: NetChangeObserver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 网络改变的一个回掉类
        mNetChangeObserver = object : NetChangeObserver {
            override fun onNetConnected(type: NetUtils.NetType) {
                onNetworkConnected(type)
            }

            override fun onNetDisConnect() {
                onNetworkDisConnected()
            }
        }

        //开启广播去监听 网络 改变事件
        NetStateReceiver.registerObserver(mNetChangeObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    /**
     * 网络连接状态

     * @param type 网络状态
     */
    protected abstract fun onNetworkConnected(type: NetUtils.NetType)

    /**
     * 网络断开的时候调用
     */
    protected abstract fun onNetworkDisConnected()
}