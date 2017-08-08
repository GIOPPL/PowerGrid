package com.gioppl.powergrid.NetWork

import android.graphics.Bitmap
import android.util.Log
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.BitmapCallback
import com.zhy.http.okhttp.callback.StringCallback
import okhttp3.Call
import java.lang.Exception




/**
 * Created by GIOPPL on 2017/7/27.
 */
class OneNetWork (getData:getDataSuccessful){
    private var getData:getDataSuccessful?=null
    init {
        this.getData=getData
        RequestData()
        downImage()
    }

    /**
     * get请求
     */
    private fun RequestData() {
        val url = "http://202.113.244.44:9012/loginAction.do"
        OkHttpUtils
                .get()
                .url(url)
                .addParams("zjh","02210150204")
                .addParams("mm","ESUPMT")
                .build()
                .execute(object : StringCallback() {
                    override fun onResponse(response: String?, id: Int) {
                        Log.e("##",""+response);

                    }

                    override fun onError(call: Call?, e: Exception?, id: Int) {
                        Log.e("##",""+call.toString()+e.toString()+id);
                    }
                } )
        getData!!.success()
    }

    /**
     * 下载图片
     */
    private fun downImage(){
        OkHttpUtils
                .get()//
                .url("http://img2.3lian.com/img2009/06/16/019.jpg")//
                .build()//
                .execute(object : BitmapCallback() {
                    override fun onResponse(response: Bitmap?, id: Int) {
                        Log.e("##","下载图片成功");
                        getData!!.downImage(response)
                    }
                    override fun onError(call: Call?, e: Exception?, id: Int) {

                    }

                })
    }


    interface getDataSuccessful{
        fun success()
        fun downImage(response: Bitmap?)
    }
}