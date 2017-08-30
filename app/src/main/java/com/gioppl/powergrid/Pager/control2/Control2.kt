package com.gioppl.powergrid.Pager.Control2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.getbase.floatingactionbutton.FloatingActionButton
import com.gioppl.powergrid.Pager.Control.ControlAdapt2
import com.gioppl.powergrid.Pager.Control.ControlEquipmentBean2
import com.gioppl.powergrid.R
import com.gioppl.powergrid.bean.ControlEntity
import com.gioppl.powergrid.function.PinchImageView
import com.gioppl.powergrid.present.ControlPresent
import com.gioppl.powergrid.view.ControlView

/**
 * Created by GIOPPL on 2017/7/24.
 */
class Control2 : Fragment(),View.OnClickListener , ControlView {
    var present: ControlPresent?=null
    var show=1//偶数为显示控制界面，奇数为显示图片界面
    var mRV: RecyclerView?=null
    var mAdapt: ControlAdapt2?=null
    var mList:ArrayList<ControlEquipmentBean2> ?= ArrayList()
    var fbtn_image:FloatingActionButton?=null
    var pim_control: PinchImageView?=null
    var lin_control: LinearLayout?=null
    var layoutManager :GridLayoutManager?=null
    //四大菜单
    var tv_make:TextView?=null
    var tv_use:TextView?=null
    var tv_store: TextView?=null
    var tv_other:TextView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.control, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
//        initData()
        initRV()
        getData()
    }

    private fun getData() {
        present= ControlPresent(activity)
        present!!.onCreate()
        present!!.getData(this)
    }

    private fun initView() {
        tv_make= activity.findViewById(R.id.tv_control_makeE) as TextView?
        tv_use= activity.findViewById(R.id.tv_control_useE) as TextView?
        tv_store= activity.findViewById(R.id.tv_control_storeE) as TextView?
        tv_other= activity.findViewById(R.id.tv_control_otherE) as TextView?
        //设置监听事件
        tv_make!!.setOnClickListener(this);
        tv_use!!.setOnClickListener(this);
        tv_store!!.setOnClickListener(this);
        tv_other!!.setOnClickListener(this);

        lin_control= activity.findViewById(R.id.lin_control) as LinearLayout?
        pim_control= activity.findViewById(R.id.pim_control) as PinchImageView?
        pim_control!!.visibility=View.GONE
        fbtn_image= activity.findViewById(R.id.fbtn_control_manageImage) as FloatingActionButton?
        fbtn_image!!.setIconDrawable(resources.getDrawable(R.drawable.photo))
        fbtn_image!!.setOnClickListener {
            if (show%2==0){//显示控制界面
                pim_control!!.visibility=View.GONE
                lin_control!!.visibility=View.VISIBLE
            }else{
                pim_control!!.visibility=View.VISIBLE
                lin_control!!.visibility=View.GONE
            }
            show++
        }

    }

    private fun initData() {
        var bean: ControlEquipmentBean2?= ControlEquipmentBean2()
        bean!!.name="A座行政楼"
        var beanList:ArrayList<ControlEquipmentBean2.Equipment>?= ArrayList();
        beanList!!.add(ControlEquipmentBean2.Equipment())
        beanList!!.add(ControlEquipmentBean2.Equipment())
        beanList!!.add(ControlEquipmentBean2.Equipment())
        bean.equipmentInfo=beanList
        for (x in 1..10)
            mList!!.add(bean)
    }

    //初始化recyclerView
    private fun initRV() {
        mRV= activity.findViewById(R.id.RV_control) as RecyclerView?
        mAdapt= ControlAdapt2(mList!!,activity)
        layoutManager = GridLayoutManager(activity,1);//set hte number of column on this boundary
        mRV!!.setLayoutManager(layoutManager)
        layoutManager!!.orientation = OrientationHelper.VERTICAL
        mRV!!.adapter=mAdapt
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.tv_control_makeE -> mRV!!.scrollToPosition(1)
            R.id.tv_control_storeE -> mRV!!.scrollToPosition(3)
            R.id.tv_control_useE -> mRV!!.scrollToPosition(5)
            R.id.tv_control_otherE -> mRV!!.scrollToPosition(8)
        }
    }

    override fun onSuccess(entity: ControlEntity) {
        var bean: ControlEquipmentBean2?= ControlEquipmentBean2()


        //提娜佳光伏单元
        bean!!.name="光伏单元"
        var beanList:ArrayList<ControlEquipmentBean2.Equipment>?= ArrayList();
        for (x in entity.gfdy){
            var a= ControlEquipmentBean2.Equipment()
            a.equName=x.name+" "+x.value
            beanList!!.add(a)
        }
        bean.equipmentInfo=beanList!!
        mList!!.add(bean)


        //添加储能单元
        beanList.clear()
        bean!!.name="储能单元"
        for (x in entity.cndy){
            var a= ControlEquipmentBean2.Equipment()
            a.equName=x.name+" "+x.value
            beanList!!.add(a)
        }
        mList!!.add(bean)

        //添加负载单元
        beanList.clear()
        bean!!.name="负载单元"
        for (x in entity.fzdy){
            var a= ControlEquipmentBean2.Equipment()
            a.equName=x.name+" "+x.value
            beanList!!.add(a)
        }
        mList!!.add(bean)
        mAdapt!!.notifyDataSetChanged()
    }

    override fun onError(e: String) {
        //
    }

    override fun onStop() {
        super.onStop()
        present!!.onStop()
    }
}