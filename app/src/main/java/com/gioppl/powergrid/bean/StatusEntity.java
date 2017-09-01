package com.gioppl.powergrid.bean;

import java.util.List;

/**
 * Created by GIOPPL on 2017/9/1.
 */

public class StatusEntity {

    private List<StatisticDataBean> statisticData;

    public List<StatisticDataBean> getStatisticData() {
        return statisticData;
    }

    public void setStatisticData(List<StatisticDataBean> statisticData) {
        this.statisticData = statisticData;
    }

    public static class StatisticDataBean {
        /**
         * NAME : RFDL
         * VALUE : 99
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
