package com.gioppl.powergrid.Pager.Status

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.gioppl.powergrid.R









/**
 * Created by GIOPPL on 2017/7/24.
 */

class Status : Fragment(){
    var fim_head: SimpleDraweeView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.test, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        val uri = Uri.parse("res://drawable/" + R.drawable.power)


        val mDraweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                //加载drawable里的一张gif图
                .setUri(Uri.parse("res://drawable/" + R.drawable.power))//设置uri
                .build()
//设置Controller
        fim_head!!.setController(mDraweeController)
//        fim_head!!.setImageURI(uri)
//        fim_head!!.setImageURI("http://ac-ri5cfios.clouddn.com/oj3kcf4jRLz8s3IOJeQ3NWhCoOur6TXFpTluHGeV.png")
//        fim_head!!.drawable=draw

    }

    private fun initView() {
        fim_head= activity.findViewById(R.id.fim_four_head) as SimpleDraweeView?
    }
}
