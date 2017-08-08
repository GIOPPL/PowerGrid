package com.gioppl.powergrid.adapt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.gioppl.powergrid.Pager.Data.ThreeDetail.ThreeDetail
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.EquipmentBean

/**
 * Created by GIOPPL on 2017/7/24.
 */
class ThreeAdapt(mList:ArrayList<EquipmentBean>,mContext:Context): RecyclerView.Adapter<ThreeAdapt.MyViewHolder>() {
    private var mList:ArrayList<EquipmentBean>?=null
    private var mContext:Context?=null
    init {
        this.mList=mList
        this.mContext=mContext
    }

    override fun getItemCount()=mList!!.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            =MyViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_three,parent,false))

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
            holder!!.tv_name!!.setText(mList!![position].name)
            setImage(holder.im_equ,position)
            setLinOnclik(holder.lin_father,position)
    }

    private fun setLinOnclik(lin_father: LinearLayout?, position: Int) {
        lin_father!!.setOnClickListener {
            var intent=Intent(mContext, ThreeDetail::class.java)
            val bundle = Bundle()
            bundle.putSerializable("bean", mList!![position])
            intent.putExtras(bundle)
            mContext!!.startActivity(intent)
        }
    }

    private fun setImage(im_equ: SimpleDraweeView?, position: Int) {
        if (mList!![position].equals(null)||mList!![position].equals("")) return
        im_equ!!.setImageURI(mList!![position].url);

    }

    class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var im_equ= itemView.findViewById(R.id.im_three_equ) as SimpleDraweeView?
        var tv_name=itemView.findViewById(R.id.tv_three_name) as TextView?
        var lin_father=itemView.findViewById(R.id.lin_three_father) as LinearLayout?
    }


}