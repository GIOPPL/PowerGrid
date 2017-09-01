package com.gioppl.powergrid.bean;

/**
 * Created by GIOPPL on 2017/8/25.
 */
/**
 * CNZGL : 67.6kW
 * FS : 0m/s
 * BWZGL : 2.1kW
 * FZZGL : 5kW
 * WD : 31.1 °C
 * RZ : 4W/m²
 * RFDL : 99kWh
 * MODE : 离网VF
 * GFZGL : 4.512kW
 * ZFDL : 0kWh
 */
public class ConclusionEntity {

    /**
     * overview : {"CNZGL":"67.6kW","FS":"0m/s","BWZGL":"2.1kW","FZZGL":"5kW","WD":"31.1 °C","RZ":"4W/m²","RFDL":"99kWh","MODE":"离网VF","GFZGL":"45kW","ZFDL":"10998kWh"}
     * notice : {"公告2":{"STATE":"1","CONTENT":"我们将于2017年9月11日11:00-12:30期间，对光伏微网后台进行定期维护。维护期间，系统将会暂停开放访问！"},"公告1":{"STATE":"1","CONTENT":"我们将于2017年8月31日22:00-23:30期间，对光伏微网后台进行升级。升级期间，系统将会暂停开放访问！"}}
     */

    private OverviewBean overview;
    private NoticeBean notice;

    public OverviewBean getOverview() {
        return overview;
    }

    public void setOverview(OverviewBean overview) {
        this.overview = overview;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public static class OverviewBean {
        /**
         * CNZGL : 67.6kW
         * FS : 0m/s
         * BWZGL : 2.1kW
         * FZZGL : 5kW
         * WD : 31.1 °C
         * RZ : 4W/m²
         * RFDL : 99kWh
         * MODE : 离网VF
         * GFZGL : 45kW
         * ZFDL : 10998kWh
         */

        private String CNZGL;
        private String FS;
        private String BWZGL;
        private String FZZGL;
        private String WD;
        private String RZ;
        private String RFDL;
        private String MODE;
        private String GFZGL;
        private String ZFDL;

        public String getCNZGL() {
            return CNZGL;
        }

        public void setCNZGL(String CNZGL) {
            this.CNZGL = CNZGL;
        }

        public String getFS() {
            return FS;
        }

        public void setFS(String FS) {
            this.FS = FS;
        }

        public String getBWZGL() {
            return BWZGL;
        }

        public void setBWZGL(String BWZGL) {
            this.BWZGL = BWZGL;
        }

        public String getFZZGL() {
            return FZZGL;
        }

        public void setFZZGL(String FZZGL) {
            this.FZZGL = FZZGL;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getRZ() {
            return RZ;
        }

        public void setRZ(String RZ) {
            this.RZ = RZ;
        }

        public String getRFDL() {
            return RFDL;
        }

        public void setRFDL(String RFDL) {
            this.RFDL = RFDL;
        }

        public String getMODE() {
            return MODE;
        }

        public void setMODE(String MODE) {
            this.MODE = MODE;
        }

        public String getGFZGL() {
            return GFZGL;
        }

        public void setGFZGL(String GFZGL) {
            this.GFZGL = GFZGL;
        }

        public String getZFDL() {
            return ZFDL;
        }

        public void setZFDL(String ZFDL) {
            this.ZFDL = ZFDL;
        }
    }

    public static class NoticeBean {
        /**
         * 公告2 : {"STATE":"1","CONTENT":"我们将于2017年9月11日11:00-12:30期间，对光伏微网后台进行定期维护。维护期间，系统将会暂停开放访问！"}
         * 公告1 : {"STATE":"1","CONTENT":"我们将于2017年8月31日22:00-23:30期间，对光伏微网后台进行升级。升级期间，系统将会暂停开放访问！"}
         */

        private 公告2Bean 公告2;
        private 公告1Bean 公告1;

        public 公告2Bean get公告2() {
            return 公告2;
        }

        public void set公告2(公告2Bean 公告2) {
            this.公告2 = 公告2;
        }

        public 公告1Bean get公告1() {
            return 公告1;
        }

        public void set公告1(公告1Bean 公告1) {
            this.公告1 = 公告1;
        }

        public static class 公告2Bean {
            /**
             * STATE : 1
             * CONTENT : 我们将于2017年9月11日11:00-12:30期间，对光伏微网后台进行定期维护。维护期间，系统将会暂停开放访问！
             */

            private String STATE;
            private String CONTENT;

            public String getSTATE() {
                return STATE;
            }

            public void setSTATE(String STATE) {
                this.STATE = STATE;
            }

            public String getCONTENT() {
                return CONTENT;
            }

            public void setCONTENT(String CONTENT) {
                this.CONTENT = CONTENT;
            }
        }

        public static class 公告1Bean {
            /**
             * STATE : 1
             * CONTENT : 我们将于2017年8月31日22:00-23:30期间，对光伏微网后台进行升级。升级期间，系统将会暂停开放访问！
             */

            private String STATE;
            private String CONTENT;

            public String getSTATE() {
                return STATE;
            }

            public void setSTATE(String STATE) {
                this.STATE = STATE;
            }

            public String getCONTENT() {
                return CONTENT;
            }

            public void setCONTENT(String CONTENT) {
                this.CONTENT = CONTENT;
            }
        }
    }
}
