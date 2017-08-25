package com.gioppl.powergrid.bean;

/**
 * Created by GIOPPL on 2017/8/25.
 */

public class ConclusionEntity {

    /**
     * overview : {"CNZGL":"5.1kW","FS":"0m/s","BWZGL":"2.1kW","FZZGL":"5kW","WD":"31.1 °C","RZ":"4W/m²","MODE":"离网VF","GFZGL":"4.512kW"}
     */

    private OverviewBean overview;

    public OverviewBean getOverview() {
        return overview;
    }

    public void setOverview(OverviewBean overview) {
        this.overview = overview;
    }

    public static class OverviewBean {
        /**
         * CNZGL : 5.1kW 储能总功率!
         * FS : 0m/s 风速
         * BWZGL : 2.1kW 并网总功率!
         * FZZGL : 5kW 负载总功率!
         * WD : 31.1 °C 温度
         * RZ : 4W/m² 光照
         * MODE : 离网VF 模式
         * GFZGL : 4.512kW 光伏总功率!
         */

        private String CNZGL;
        private String FS;
        private String BWZGL;
        private String FZZGL;
        private String WD;
        private String RZ;
        private String MODE;
        private String GFZGL;

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

        @Override
        public String toString() {
            return "OverviewBean{" +
                    "CNZGL='" + CNZGL + '\'' +
                    ", FS='" + FS + '\'' +
                    ", BWZGL='" + BWZGL + '\'' +
                    ", FZZGL='" + FZZGL + '\'' +
                    ", WD='" + WD + '\'' +
                    ", RZ='" + RZ + '\'' +
                    ", MODE='" + MODE + '\'' +
                    ", GFZGL='" + GFZGL + '\'' +
                    '}';
        }
    }

}
