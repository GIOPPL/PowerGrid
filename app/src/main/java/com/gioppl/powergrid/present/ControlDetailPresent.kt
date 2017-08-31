package com.gioppl.powergrid.present

import android.content.Context
import android.util.Log
import com.gioppl.powergrid.bean.ControlDetailEntity
import com.gioppl.powergrid.netWork.ControlDetailRetrofitHelper
import com.gioppl.powergrid.view.ControlDetailView
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by GIOPPL on 2017/8/25.
 */
class ControlDetailPresent(var context: Context){
    private var mCompositeSubscription:CompositeSubscription?=null
    private var mHelper: ControlDetailRetrofitHelper?=null

    fun onCreate(){
        mCompositeSubscription= CompositeSubscription()
        mHelper= ControlDetailRetrofitHelper()

    }
    fun onStop(){
        if (mCompositeSubscription!!.hasSubscriptions())
            mCompositeSubscription!!.unsubscribe()
    }
    fun getData(v:ControlDetailView,equName:String){
        mCompositeSubscription!!.add(ControlDetailRetrofitHelper.getInstance(equName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ControlDetailEntity> {
                    override fun onCompleted() {
                        log("completed")
                    }

                    override fun onError(e: Throwable) {
//                        log("error"+e.message)
                        v.onError(e.toString())
                    }

                    override fun onNext(m: ControlDetailEntity) {
//                        log("success")
                        v.onSuccess(m)
                    }
                })
        )

    }

    fun log(text:String){
        Log.i("ControlDetailPresent##",text)
    }
}