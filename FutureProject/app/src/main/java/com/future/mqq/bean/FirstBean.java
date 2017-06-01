package com.future.mqq.bean;

/**
 * Created by lenovo on 2017/5/25.
 */

public class FirstBean {

    /**
     * data : {"private_key":"1A808C1B70D645C730641FE245EB3C688DCF1148","app_id":"123SXTW1"}
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
         * private_key : 1A808C1B70D645C730641FE245EB3C688DCF1148
         * app_id : 123SXTW1
         */

        private String private_key;
        private String app_id;

        public String getPrivate_key() {
            return private_key;
        }

        public void setPrivate_key(String private_key) {
            this.private_key = private_key;
        }

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }
    }
}
