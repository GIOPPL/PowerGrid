package com.gioppl.powergrid.bean;

/**
 * Created by GIOPPL on 2017/8/31.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * WORK_ZT : 0
 * DY_A : 200 A相电压
 * DWPL : 0
 * RFDL : 11 日发电量
 * DY_C : 210 C相电压
 * DY_B : 210 B相电压
 * JNKQWD : 1.2
 * ZYGGL : 1
 * ZYXSJ : 0    总运行时间
 * SCLX : 1
 * NBQXL : 0 逆变器效率
 * ZLDL2 : 4.5
 * ZLDL1 : 5.5
 * BJ : 00000000
 * EDSUGL : 5
 * INTZT : 0
 * ZT : 0000000000000000000000
 * DATAFLAG : 0
 * DL_C : 0 C相电流
 * DL_B : 0 B相电流
 * DL_A : 1.3 A相电流
 * DEVICECODE : NBJ01   设备名称
 * ZTSJ : 2016-05-31-17-07-20
 * ZZLGL : 0.1 总直流功率
 * ZLDY2 : 230
 * ZLDY1 : 220
 * ZFDL : 0 总发电量
 */

public class ControlDetailEntity {
    private ArrayList<RESULTBean> RESULT;

    public List<RESULTBean> getRESULT() {
        return RESULT;
    }

    public void setRESULT(ArrayList<RESULTBean> RESULT) {
        this.RESULT = RESULT;
    }

    public static class RESULTBean {
        /**
         * NAME : DEVICECODE
         * VALUE : NBJ01
         */

        private String NAME;
        private String VALUE;

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getVALUE() {
            return VALUE;
        }

        public void setVALUE(String VALUE) {
            this.VALUE = VALUE;
        }
    }
}
