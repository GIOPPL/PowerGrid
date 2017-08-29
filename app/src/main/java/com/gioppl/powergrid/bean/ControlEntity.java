package com.gioppl.powergrid.bean;

import java.util.List;

/**
 * Created by GIOPPL on 2017/8/28.
 */

public class ControlEntity {

    private List<FZDYBean> FZDY;
    private List<GFDYBean> GFDY;
    private List<CNDYBean> CNDY;

    public List<FZDYBean> getFZDY() {
        return FZDY;
    }

    public void setFZDY(List<FZDYBean> FZDY) {
        this.FZDY = FZDY;
    }

    public List<GFDYBean> getGFDY() {
        return GFDY;
    }

    public void setGFDY(List<GFDYBean> GFDY) {
        this.GFDY = GFDY;
    }

    public List<CNDYBean> getCNDY() {
        return CNDY;
    }

    public void setCNDY(List<CNDYBean> CNDY) {
        this.CNDY = CNDY;
    }

    public static class FZDYBean {
        /**
         * NAME : 照明负载
         * VALUE : 3.1kW
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

    public static class GFDYBean {
        /**
         * NAME : 逆变器01
         * VALUE : 1.1kW
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

    public static class CNDYBean {
        /**
         * NAME : PCS
         * VALUE : 2.1kW
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
