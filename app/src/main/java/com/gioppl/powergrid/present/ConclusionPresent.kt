package com.gioppl.powergrid.present

import android.content.Context
import android.util.Log
import com.gioppl.powergrid.bean.ConclusionEntity
import com.gioppl.powergrid.netWork.ConclusionRetrofitHelper
import com.gioppl.powergrid.view.ConclusionView
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by GIOPPL on 2017/8/25.
 */
class ConclusionPresent(var context: Context){
    private var mConclusionView:ConclusionView?=null
    private var mCompositeSubscription:CompositeSubscription?=null
    private var mHelper: ConclusionRetrofitHelper?=null

    fun onCreate(){
        mCompositeSubscription= CompositeSubscription()
        mHelper= ConclusionRetrofitHelper()

    }
    fun onStop(){
        if (mCompositeSubscription!!.hasSubscriptions())
            mCompositeSubscription!!.unsubscribe()
    }
    fun getData(v:ConclusionView){
        mCompositeSubscription!!.add(ConclusionRetrofitHelper.getInstance()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ConclusionEntity> {
                    override fun onCompleted() {
                        log("completed")
                    }

                    override fun onError(e: Throwable) {
                        log("error"+e.message)
                        v.onError(e.toString())
                    }

                    override fun onNext(m: ConclusionEntity) {
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