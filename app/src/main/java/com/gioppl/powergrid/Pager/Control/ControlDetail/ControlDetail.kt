package com.gioppl.powergrid.Pager.Control.ControlDetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.ControlEntity
import com.gioppl.powergrid.view.ControlView

/**
 * Created by GIOPPL on 2017/8/28.
 */
class ControlDetail : AppCompatActivity(),ControlView {
    override fun onSuccess(entity: ControlEntity) {
        //
    }

    override fun onError(e: String) {
        //
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.control_detail)
    }
}