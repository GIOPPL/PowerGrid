package com.gioppl.powergrid.Pager.Control

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.gioppl.powergrid.Pager.Control.ControlDetail.ControlDetail
import com.gioppl.powergrid.R

/**
 * Created by GIOPPL on 2017/8/8.
 */
class ControlItemAdapt2(mActivity: Activity, var mList:ArrayList<ControlEquipmentBean2.Equipment>) : RecyclerView.Adapter<ControlItemAdapt2.MyViewHolder>() {
    private var mActivity: Activity? = null

    init {
//        for (x in 1..10)
//        mList!!.add(ControlEquipmentBean2.Equipment())
        this.mActivity = mActivity
    }

    override fun onBindViewHolder(holder: ControlItemAdapt2.MyViewHolder?, position: Int) {
        holder!!.sim_image!!.setImageURI(mList!!.get(position).imageUrl)
        holder!!.sim_image!!.setOnClickListener {
            holder!!.v_shade!!.visibility=View.VISIBLE
        }
        holder!!.v_shade!!.setOnClickListener {
            holder!!.v_shade!!.visibility=View.GONE
            mActivity!!.startActivity(Intent(mActivity,ControlDetail::class.java))
        }
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var sim_image: SimpleDraweeView?=null
        var tv_name:TextView?=null
        var v_shade:View?=null
        init {
            v_shade=itemView!!.findViewById(R.id.v_shade)
            sim_image= itemView!!.findViewById(R.id.sim_controlItem2) as SimpleDraweeView?
            tv_name= itemView!!.findViewById(R.id.tv_controlItem2_name) as TextView?
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ControlItemAdapt2.MyViewHolder?
            = MyViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.control_item_item, parent, false))

    override fun getItemCount() = mList!!.size
    private fun log(string:String){
        Log.i("##",string);
    }
}