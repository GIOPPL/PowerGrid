package com.gioppl.powergrid.present

import android.content.Context
import android.util.Log
import com.gioppl.powergrid.bean.ControlEntity
import com.gioppl.powergrid.bean.StatusEntity
import com.gioppl.powergrid.netWork.ControlRetrofitHelper
import com.gioppl.powergrid.netWork.StatusRetrofitHelper
import com.gioppl.powergrid.view.ControlView
import com.gioppl.powergrid.view.StatusView
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by GIOPPL on 2017/8/25.
 */
class StatusPresent(var context: Context){
    private var mCompositeSubscription:CompositeSubscription?=null
    private var mHelper: StatusRetrofitHelper?=null

    fun onCreate(){
        mCompositeSubscription= CompositeSubscription()
        mHelper= StatusRetrofitHelper()

    }
    fun onStop(){
        if (mCompositeSubscription!!.hasSubscriptions())
            mCompositeSubscription!!.unsubscribe()
    }
    fun getData(v: StatusView){
        mCompositeSubscription!!.add(StatusRetrofitHelper.getInstance()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<StatusEntity> {
                    override fun onCompleted() {
                        log("completed")
                    }

                    override fun onError(e: Throwable) {
                        log("error"+e.message)
                        v.onError(e.toString())
                    }

                    override fun onNext(m: StatusEntity) {
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