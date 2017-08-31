package com.gioppl.powergrid.present

import android.content.Context
import android.util.Log
import com.gioppl.powergrid.bean.ControlEntity
import com.gioppl.powergrid.netWork.ConclusionRetrofitHelper
import com.gioppl.powergrid.netWork.ControlRetrofitHelper
import com.gioppl.powergrid.view.ControlView
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by GIOPPL on 2017/8/25.
 */
class ControlPresent(var context: Context){
    private var mCompositeSubscription:CompositeSubscription?=null
    private var mHelper: ControlRetrofitHelper?=null

    fun onCreate(){
        mCompositeSubscription= CompositeSubscription()
        mHelper= ControlRetrofitHelper()

    }
    fun onStop(){
        if (mCompositeSubscription!!.hasSubscriptions())
            mCompositeSubscription!!.unsubscribe()
    }
    fun getData(v:ControlView){
        mCompositeSubscription!!.add(ControlRetrofitHelper.getInstance()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ControlEntity> {
                    override fun onCompleted() {
                        log("completed")
                    }

                    override fun onError(e: Throwable) {
                        log("error"+e.message)
                        v.onError(e.toString())
                    }

                    override fun onNext(m: ControlEntity) {
                        log("success")
                        v.onSuccess(m)
                    }
                })
        )

    }

    fun log(text:String){
        Log.i("##",text)
    }
}