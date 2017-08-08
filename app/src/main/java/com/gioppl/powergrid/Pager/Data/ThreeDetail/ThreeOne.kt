package com.gioppl.powergrid.Pager.Data.ThreeDetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gioppl.powergrid.R
import lecho.lib.hellocharts.model.Axis
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.util.ChartUtils
import lecho.lib.hellocharts.view.ColumnChartView


/**
 * Created by GIOPPL on 2017/7/25.
 */
class ThreeOne : Fragment() {
    private var EQUIPMENT_NUM=9//设备数量
    private var mList:ArrayList<Float>?=null
    private var mColumnChartView: ColumnChartView? = null//柱形图
    private var mColumnChartData: ColumnChartData? = null//数据

    var columnView:ColumnChartView?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater!!.inflate(R.layout.three_one, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mColumnChartView= activity.findViewById(R.id.column_threeOne) as ColumnChartView?
        mColumnChartView!!.setZoomEnabled(false);//开启手势缩放
//        val v = mColumnChartView!!.getMaximumViewport()
//        v.top = 12f
//        mColumnChartView!!.setCurrentViewport(v)
        addData()
        initView()
    }

    /**
     * 添加数据
     */
    private fun addData() {
        mList= ArrayList()
        for (x in 0..8)
            mList!!.add(x.toFloat())
        mList!!.add(90f)
    }

    private fun initView() {
        /*========== 柱状图数据填充 ==========*/
        val columnList = ArrayList<Column>() //柱子列表
        var subcolumnValueList: MutableList<SubcolumnValue>     //子柱列表（即一个柱子，因为一个柱子可分为多个子柱）
        for (i in 0..EQUIPMENT_NUM) {
            subcolumnValueList = ArrayList()
            subcolumnValueList.add(SubcolumnValue(mList!!.get(i), ChartUtils.pickColor()))

            val column = Column(subcolumnValueList)
            columnList.add(column)
            column.setHasLabels(true);//☆☆☆☆☆设置列标签

        }
        mColumnChartData = ColumnChartData(columnList)               //设置数据


        /*===== 坐标轴相关设置 =====*/

        val axisX = Axis()
        val axisY = Axis().setHasLines(true)
        axisX.setName("串号")    //设置横轴名称
        axisY.setName("功率(kw)")    //设置竖轴名称
        mColumnChartData!!.setAxisXBottom(axisX) //设置横轴
        mColumnChartData!!.setAxisYLeft(axisY)   //设置竖轴



        //以上所有设置的数据、坐标配置都已存放到mColumnChartData中，接下来给mColumnChartView设置这些配置
        mColumnChartView!!.setColumnChartData(mColumnChartData)
    }
}