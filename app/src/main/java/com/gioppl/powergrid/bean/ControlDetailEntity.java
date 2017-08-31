package com.gioppl.powergrid.bean;

/**
 * Created by GIOPPL on 2017/8/31.
 */
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

    /**
     * NBJ01 : {"WORK_ZT":"0","DY_A":"200","DWPL":"0","RFDL":"11","DY_C":"210","DY_B":"210","JNKQWD":"1.2","ZYGGL":"1","ZYXSJ":"0","SCLX":"1","NBQXL":"0","ZLDL2":"4.5","ZLDL1":"5.5","BJ":"00000000","EDSUGL":"5","INTZT":"0","ZT":"0000000000000000000000","DATAFLAG":"0","DL_C":"0","DL_B":"0","DL_A":"1.3","DEVICECODE":"NBJ01","ZTSJ":"2016-05-31-17-07-20","ZZLGL":"0.1","ZLDY2":"230","ZLDY1":"220","ZFDL":"0"}
     */

    private NBJ01Bean NBJ01;

    public NBJ01Bean getNBJ01() {
        return NBJ01;
    }

    public void setNBJ01(NBJ01Bean NBJ01) {
        this.NBJ01 = NBJ01;
    }

    public static class NBJ01Bean {
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

        private String WORK_ZT;
        private String DY_A;
        private String DWPL;
        private String RFDL;
        private String DY_C;
        private String DY_B;
        private String JNKQWD;
        private String ZYGGL;
        private String ZYXSJ;
        private String SCLX;
        private String NBQXL;
        private String ZLDL2;
        private String ZLDL1;
        private String BJ;
        private String EDSUGL;
        private String INTZT;
        private String ZT;
        private String DATAFLAG;
        private String DL_C;
        private String DL_B;
        private String DL_A;
        private String DEVICECODE;
        private String ZTSJ;
        private String ZZLGL;
        private String ZLDY2;
        private String ZLDY1;
        private String ZFDL;

        public String getWORK_ZT() {
            return WORK_ZT;
        }

        public void setWORK_ZT(String WORK_ZT) {
            this.WORK_ZT = WORK_ZT;
        }

        public String getDY_A() {
            return DY_A;
        }

        public void setDY_A(String DY_A) {
            this.DY_A = DY_A;
        }

        public String getDWPL() {
            return DWPL;
        }

        public void setDWPL(String DWPL) {
            this.DWPL = DWPL;
        }

        public String getRFDL() {
            return RFDL;
        }

        public void setRFDL(String RFDL) {
            this.RFDL = RFDL;
        }

        public String getDY_C() {
            return DY_C;
        }

        public void setDY_C(String DY_C) {
            this.DY_C = DY_C;
        }

        public String getDY_B() {
            return DY_B;
        }

        public void setDY_B(String DY_B) {
            this.DY_B = DY_B;
        }

        public String getJNKQWD() {
            return JNKQWD;
        }

        public void setJNKQWD(String JNKQWD) {
            this.JNKQWD = JNKQWD;
        }

        public String getZYGGL() {
            return ZYGGL;
        }

        public void setZYGGL(String ZYGGL) {
            this.ZYGGL = ZYGGL;
        }

        public String getZYXSJ() {
            return ZYXSJ;
        }

        public void setZYXSJ(String ZYXSJ) {
            this.ZYXSJ = ZYXSJ;
        }

        public String getSCLX() {
            return SCLX;
        }

        public void setSCLX(String SCLX) {
            this.SCLX = SCLX;
        }

        public String getNBQXL() {
            return NBQXL;
        }

        public void setNBQXL(String NBQXL) {
            this.NBQXL = NBQXL;
        }

        public String getZLDL2() {
            return ZLDL2;
        }

        public void setZLDL2(String ZLDL2) {
            this.ZLDL2 = ZLDL2;
        }

        public String getZLDL1() {
            return ZLDL1;
        }

        public void setZLDL1(String ZLDL1) {
            this.ZLDL1 = ZLDL1;
        }

        public String getBJ() {
            return BJ;
        }

        public void setBJ(String BJ) {
            this.BJ = BJ;
        }

        public String getEDSUGL() {
            return EDSUGL;
        }

        public void setEDSUGL(String EDSUGL) {
            this.EDSUGL = EDSUGL;
        }

        public String getINTZT() {
            return INTZT;
        }

        public void setINTZT(String INTZT) {
            this.INTZT = INTZT;
        }

        public String getZT() {
            return ZT;
        }

        public void setZT(String ZT) {
            this.ZT = ZT;
        }

        public String getDATAFLAG() {
            return DATAFLAG;
        }

        public void setDATAFLAG(String DATAFLAG) {
            this.DATAFLAG = DATAFLAG;
        }

        public String getDL_C() {
            return DL_C;
        }

        public void setDL_C(String DL_C) {
            this.DL_C = DL_C;
        }

        public String getDL_B() {
            return DL_B;
        }

        public void setDL_B(String DL_B) {
            this.DL_B = DL_B;
        }

        public String getDL_A() {
            return DL_A;
        }

        public void setDL_A(String DL_A) {
            this.DL_A = DL_A;
        }

        public String getDEVICECODE() {
            return DEVICECODE;
        }

        public void setDEVICECODE(String DEVICECODE) {
            this.DEVICECODE = DEVICECODE;
        }

        public String getZTSJ() {
            return ZTSJ;
        }

        public void setZTSJ(String ZTSJ) {
            this.ZTSJ = ZTSJ;
        }

        public String getZZLGL() {
            return ZZLGL;
        }

        public void setZZLGL(String ZZLGL) {
            this.ZZLGL = ZZLGL;
        }

        public String getZLDY2() {
            return ZLDY2;
        }

        public void setZLDY2(String ZLDY2) {
            this.ZLDY2 = ZLDY2;
        }

        public String getZLDY1() {
            return ZLDY1;
        }

        public void setZLDY1(String ZLDY1) {
            this.ZLDY1 = ZLDY1;
        }

        public String getZFDL() {
            return ZFDL;
        }

        public void setZFDL(String ZFDL) {
            this.ZFDL = ZFDL;
        }
    }
}
