package com.gioppl.powergrid.Pager.Control

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.gioppl.powergrid.Pager.Control.ControlDetail.ControlDetail
import com.gioppl.powergrid.R


/**
 * Created by GIOPPL on 2017/8/8.
 */
class ControlAdapt(mList: ArrayList<ControlEquipmentBean>, activity: Activity) : RecyclerView.Adapter<ControlAdapt.MyViewHolder>() {
    var mList: ArrayList<ControlEquipmentBean>? = null
    private var activity: Activity? = null

    init {
        this.activity = activity
        this.mList = mList;
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder!!.tv_place!!.text=mList!![position].name
        showImage(holder,position)
        setOnclick(holder.lin1!!,position)
        setOnclick(holder.lin2!!,position)
        setOnclick(holder.lin3!!,position)
        setOnclick(holder.lin4!!,position)
        setOnclick(holder.lin5!!,position)
        setOnclick(holder.lin6!!,position)
        setOnclick(holder.lin7!!,position)
        setOnclick(holder.lin8!!,position)
        setOnclick(holder.lin9!!,position)
    }

    private fun  setOnclick(lin: LinearLayout,position: Int) {
        lin.setOnClickListener(View.OnClickListener {
            activity!!.startActivity(Intent(activity,ControlDetail::class.java))
        })
    }

    private fun showImage(holder: MyViewHolder?, position: Int) {
        when(mList!![position].equipmentInfo.size){
            1->{holder!!.lin2!!.visibility=View.GONE
                holder.lin3!!.visibility=View.GONE
                holder.lin4!!.visibility=View.GONE
                holder.lin5!!.visibility=View.GONE
                holder.lin6!!.visibility=View.GONE
                holder.lin7!!.visibility=View.GONE
                holder.lin8!!.visibility=View.GONE
                holder.lin9!!.visibility=View.GONE

                holder.tv1!!.text= mList!![position].equipmentInfo[0].equName

                changeImage(holder.sim1!!,judgeImage(mList!![position].equipmentInfo[0].equName!!))

            }
            2->{holder!!.lin3!!.visibility=View.GONE
                holder.lin4!!.visibility=View.GONE
                holder.lin5!!.visibility=View.GONE
                holder.lin6!!.visibility=View.GONE
                holder.lin7!!.visibility=View.GONE
                holder.lin8!!.visibility=View.GONE
                holder.lin9!!.visibility=View.GONE

                holder.tv1!!.text= mList!![position].equipmentInfo[0].equName
                holder.tv2!!.text= mList!![position].equipmentInfo[1].equName

                changeImage(holder.sim1!!,judgeImage(mList!![position].equipmentInfo[0].equName!!))
                changeImage(holder.sim2!!,judgeImage(mList!![position].equipmentInfo[1].equName!!))
            }
            3->{holder!!.lin4!!.visibility=View.GONE
                holder.lin5!!.visibility=View.GONE
                holder.lin6!!.visibility=View.GONE
                holder.lin7!!.visibility=View.GONE
                holder.lin8!!.visibility=View.GONE
                holder.lin9!!.visibility=View.GONE

                holder.tv1!!.text= mList!![position].equipmentInfo[0].equName
                holder.tv2!!.text= mList!![position].equipmentInfo[1].equName
                holder.tv3!!.text= mList!![position].equipmentInfo[2].equName

                changeImage(holder.sim1!!,judgeImage(mList!![position].equipmentInfo[0].equName!!))
                changeImage(holder.sim2!!,judgeImage(mList!![position].equipmentInfo[1].equName!!))
                changeImage(holder.sim3!!,judgeImage(mList!![position].equipmentInfo[2].equName!!))
            }
            4->{holder!!.lin5!!.visibility=View.GONE
                holder.lin6!!.visibility=View.GONE
                holder.lin7!!.visibility=View.GONE
                holder.lin8!!.visibility=View.GONE
                holder.lin9!!.visibility=View.GONE

                holder.tv1!!.text= mList!![position].equipmentInfo[0].equName
                holder.tv2!!.text= mList!![position].equipmentInfo[1].equName
                holder.tv3!!.text= mList!![position].equipmentInfo[2].equName
                holder.tv4!!.text= mList!![position].equipmentInfo[3].equName

                changeImage(holder.sim1!!,judgeImage(mList!![position].equipmentInfo[0].equName!!))
                changeImage(holder.sim2!!,judgeImage(mList!![position].equipmentInfo[1].equName!!))
                changeImage(holder.sim3!!,judgeImage(mList!![position].equipmentInfo[2].equName!!))
                changeImage(holder.sim4!!,judgeImage(mList!![position].equipmentInfo[3].equName!!))
            }
            5->{holder!!.lin6!!.visibility=View.GONE
                holder!!.lin7!!.visibility=View.GONE
                holder!!.lin8!!.visibility=View.GONE
                holder!!.lin9!!.visibility=View.GONE

                holder.tv1!!.text= mList!![position]!!.equipmentInfo[0].equName
                holder.tv2!!.text= mList!![position]!!.equipmentInfo[1].equName
                holder.tv3!!.text= mList!![position]!!.equipmentInfo[2].equName
                holder.tv4!!.text= mList!![position]!!.equipmentInfo[3].equName
                holder.tv5!!.text= mList!![position]!!.equipmentInfo[4].equName

                changeImage(holder.sim1!!,judgeImage(mList!![position].equipmentInfo[0].equName!!))
                changeImage(holder.sim2!!,judgeImage(mList!![position].equipmentInfo[1].equName!!))
                changeImage(holder.sim3!!,judgeImage(mList!![position].equipmentInfo[2].equName!!))
                changeImage(holder.sim4!!,judgeImage(mList!![position].equipmentInfo[3].equName!!))
                changeImage(holder.sim5!!,judgeImage(mList!![position].equipmentInfo[4].equName!!))
            }
            6->{holder!!.lin7!!.visibility=View.GONE
                holder!!.lin8!!.visibility=View.GONE
                holder!!.lin9!!.visibility=View.GONE

                holder.tv1!!.text= mList!![position]!!.equipmentInfo[0].equName
                holder.tv2!!.text= mList!![position]!!.equipmentInfo[1].equName
                holder.tv3!!.text= mList!![position]!!.equipmentInfo[2].equName
                holder.tv4!!.text= mList!![position]!!.equipmentInfo[3].equName
                holder.tv5!!.text= mList!![position]!!.equipmentInfo[4].equName
                holder.tv6!!.text= mList!![position]!!.equipmentInfo[5].equName

                changeImage(holder.sim1!!,judgeImage(mList!![position].equipmentInfo[0].equName!!))
                changeImage(holder.sim2!!,judgeImage(mList!![position].equipmentInfo[1].equName!!))
                changeImage(holder.sim3!!,judgeImage(mList!![position].equipmentInfo[2].equName!!))
                changeImage(holder.sim4!!,judgeImage(mList!![position].equipmentInfo[3].equName!!))
                changeImage(holder.sim5!!,judgeImage(mList!![position].equipmentInfo[4].equName!!))
                changeImage(holder.sim6!!,judgeImage(mList!![position].equipmentInfo[5].equName!!))
            }
            7->{holder!!.lin8!!.visibility=View.GONE
                holder!!.lin9!!.visibility=View.GONE

                holder.tv1!!.text= mList!![position]!!.equipmentInfo[0].equName
                holder.tv2!!.text= mList!![position]!!.equipmentInfo[1].equName
                holder.tv3!!.text= mList!![position]!!.equipmentInfo[2].equName
                holder.tv4!!.text= mList!![position]!!.equipmentInfo[3].equName
                holder.tv5!!.text= mList!![position]!!.equipmentInfo[4].equName
                holder.tv6!!.text= mList!![position]!!.equipmentInfo[5].equName
                holder.tv7!!.text= mList!![position]!!.equipmentInfo[6].equName

                changeImage(holder.sim1!!,judgeImage(mList!![position].equipmentInfo[0].equName!!))
                changeImage(holder.sim2!!,judgeImage(mList!![position].equipmentInfo[1].equName!!))
                changeImage(holder.sim3!!,judgeImage(mList!![position].equipmentInfo[2].equName!!))
                changeImage(holder.sim4!!,judgeImage(mList!![position].equipmentInfo[3].equName!!))
                changeImage(holder.sim5!!,judgeImage(mList!![position].equipmentInfo[4].equName!!))
                changeImage(holder.sim6!!,judgeImage(mList!![position].equipmentInfo[5].equName!!))
                changeImage(holder.sim7!!,judgeImage(mList!![position].equipmentInfo[6].equName!!))
            }
            8->{holder!!.lin9!!.visibility=View.GONE

                holder.tv1!!.text= mList!![position]!!.equipmentInfo[0].equName
                holder.tv2!!.text= mList!![position]!!.equipmentInfo[1].equName
                holder.tv3!!.text= mList!![position]!!.equipmentInfo[2].equName
                holder.tv4!!.text= mList!![position]!!.equipmentInfo[3].equName
                holder.tv5!!.text= mList!![position]!!.equipmentInfo[4].equName
                holder.tv6!!.text= mList!![position]!!.equipmentInfo[5].equName
                holder.tv7!!.text= mList!![position]!!.equipmentInfo[6].equName
                holder.tv8!!.text= mList!![position]!!.equipmentInfo[7].equName

                changeImage(holder.sim1!!,judgeImage(mList!![position].equipmentInfo[0].equName!!))
                changeImage(holder.sim2!!,judgeImage(mList!![position].equipmentInfo[1].equName!!))
                changeImage(holder.sim3!!,judgeImage(mList!![position].equipmentInfo[2].equName!!))
                changeImage(holder.sim4!!,judgeImage(mList!![position].equipmentInfo[3].equName!!))
                changeImage(holder.sim5!!,judgeImage(mList!![position].equipmentInfo[4].equName!!))
                changeImage(holder.sim6!!,judgeImage(mList!![position].equipmentInfo[5].equName!!))
                changeImage(holder.sim7!!,judgeImage(mList!![position].equipmentInfo[6].equName!!))
                changeImage(holder.sim8!!,judgeImage(mList!![position].equipmentInfo[7].equName!!))
            }
        }
    }


    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tv_place: TextView? = null
        var sim1:SimpleDraweeView?=null
        var sim2:SimpleDraweeView?=null
        var sim3:SimpleDraweeView?=null
        var sim4:SimpleDraweeView?=null
        var sim5:SimpleDraweeView?=null
        var sim6:SimpleDraweeView?=null
        var sim7:SimpleDraweeView?=null
        var sim8:SimpleDraweeView?=null
        var sim9:SimpleDraweeView?=null

        var lin1:LinearLayout?=null
        var lin2:LinearLayout?=null
        var lin3:LinearLayout?=null
        var lin4:LinearLayout?=null
        var lin5:LinearLayout?=null
        var lin6:LinearLayout?=null
        var lin7:LinearLayout?=null
        var lin8:LinearLayout?=null
        var lin9:LinearLayout?=null

        var tv1:TextView?=null
        var tv2:TextView?=null
        var tv3:TextView?=null
        var tv4:TextView?=null
        var tv5:TextView?=null
        var tv6:TextView?=null
        var tv7:TextView?=null
        var tv8:TextView?=null
        var tv9:TextView?=null

        init {
            tv_place= itemView!!.findViewById(R.id.tv_control_place) as TextView?
            sim1= itemView.findViewById(R.id.sim_control_1) as SimpleDraweeView?
            sim2= itemView.findViewById(R.id.sim_control_2) as SimpleDraweeView?
            sim3= itemView.findViewById(R.id.sim_control_3) as SimpleDraweeView?
            sim4= itemView.findViewById(R.id.sim_control_4) as SimpleDraweeView?
            sim5= itemView.findViewById(R.id.sim_control_5) as SimpleDraweeView?
            sim6= itemView.findViewById(R.id.sim_control_6) as SimpleDraweeView?
            sim7= itemView.findViewById(R.id.sim_control_7) as SimpleDraweeView?
            sim8= itemView.findViewById(R.id.sim_control_8) as SimpleDraweeView?
            sim9= itemView.findViewById(R.id.sim_control_9) as SimpleDraweeView?

            lin1= itemView.findViewById(R.id.lin_control_1) as LinearLayout?
            lin2= itemView.findViewById(R.id.lin_control_2) as LinearLayout?
            lin3= itemView.findViewById(R.id.lin_control_3) as LinearLayout?
            lin4= itemView.findViewById(R.id.lin_control_4) as LinearLayout?
            lin5= itemView.findViewById(R.id.lin_control_5) as LinearLayout?
            lin6= itemView.findViewById(R.id.lin_control_6) as LinearLayout?
            lin7= itemView.findViewById(R.id.lin_control_7) as LinearLayout?
            lin8= itemView.findViewById(R.id.lin_control_8) as LinearLayout?
            lin9= itemView.findViewById(R.id.lin_control_9) as LinearLayout?

            tv1= itemView.findViewById(R.id.tv_control_1) as TextView?
            tv2= itemView.findViewById(R.id.tv_control_2) as TextView?
            tv3= itemView.findViewById(R.id.tv_control_3) as TextView?
            tv4= itemView.findViewById(R.id.tv_control_4) as TextView?
            tv5= itemView.findViewById(R.id.tv_control_5) as TextView?
            tv6= itemView.findViewById(R.id.tv_control_6) as TextView?
            tv7= itemView.findViewById(R.id.tv_control_7) as TextView?
            tv8= itemView.findViewById(R.id.tv_control_8) as TextView?
            tv9= itemView.findViewById(R.id.tv_control_9) as TextView?
        }
    }

    fun changeImage(im:SimpleDraweeView,sort:ImageSort){
        when(sort){
            ImageSort.逆变器->im.setImageURI(Uri.parse("res://drawable/" + R.drawable.nbq))
            ImageSort.负载->im.setImageURI(Uri.parse("res://drawable/" + R.drawable.fz))
            ImageSort.锂电池->im.setImageURI(Uri.parse("res://drawable/" + R.drawable.li_battery))
            ImageSort.PCS->im.setImageURI(Uri.parse("res://drawable/" + R.drawable.pcs))
            ImageSort.超级电容->im.setImageURI(Uri.parse("res://drawable/" + R.drawable.cjdr))
            ImageSort.双向DCDC->im.setImageURI(Uri.parse("res://drawable/" + R.drawable.sx_dc_dc))
            ImageSort.其他 ->im.setImageURI(Uri.parse("res://drawable/" + R.drawable.ic_launcher))
        }
    }

    fun judgeImage(name:String):ImageSort{
        if (name.contains("逆变器")){
            return ImageSort.逆变器
        }else if(name.contains("负载")||name.contains("预留")){
            return ImageSort.负载
        }else if(name.contains("锂电池")){
            return ImageSort.锂电池
        }else if(name.contains("PCS")){
            return ImageSort.PCS
        }else if(name.contains("超级电容")){
            return ImageSort.超级电容
        }else if(name.contains("双向DCDC")){
            return ImageSort.双向DCDC
        }else {
            return ImageSort.其他
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = MyViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.control_item, parent, false))

    override fun getItemCount() = mList!!.size

    public enum class ImageSort{
        逆变器,负载,锂电池,PCS,超级电容,双向DCDC,其他
    }

}