package com.gioppl.powergrid.Pager.Control2.ControlDetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.ControlEntity
import com.gioppl.powergrid.present.ControlPresent
import com.gioppl.powergrid.view.ControlView

/**
 * Created by GIOPPL on 2017/8/28.
 */
class ControlDetail2 : AppCompatActivity(),ControlView {

    var present:ControlPresent?=null

    override fun onSuccess(entity: ControlEntity) {
        log(entity.cndy[0].name)
    }

    override fun onError(e: String) {
        log(e)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.control_detail)
        present= ControlPresent(this)
        present!!.onCreate()
        present!!.getData(this)
    }

    override fun onStop() {
        super.onStop()
        present!!.onStop()
    }
    fun log(text:String){
        Log.i("##ControlDetail2",text)
    }

}