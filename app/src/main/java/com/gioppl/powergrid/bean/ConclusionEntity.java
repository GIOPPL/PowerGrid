package com.gioppl.powergrid.bean;

/**
 * Created by GIOPPL on 2017/8/25.
 */

public class ConclusionEntity {


    /**
     * overview : {"CNZGL":"67.6kW","FS":"0m/s","BWZGL":"2.1kW","FZZGL":"5kW","WD":"31.1 °C","RZ":"4W/m²","RFDL":"99kWh","MODE":"离网VF","GFZGL":"4.512kW","ZFDL":"0kWh"}
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
}
