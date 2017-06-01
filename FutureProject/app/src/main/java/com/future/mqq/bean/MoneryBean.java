package com.future.mqq.bean;

/**
 * Created by lenovo on 2017/6/1.
 */

public class MoneryBean {

    /**
     * data : {"cash":0}
     * ret : 0
     */

    private DataBean data;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {
        /**
         * cash : 0
         */

        private int cash;

        public int getCash() {
            return cash;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }
    }
}
