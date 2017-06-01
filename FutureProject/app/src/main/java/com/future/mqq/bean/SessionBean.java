package com.future.mqq.bean;

/**
 * Created by lenovo on 2017/5/27.
 */

public class SessionBean {

    /**
     * data : {"session":"0e1e4f7718566a1af438ba720f93058bc3e200dc","user_new":true}
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
         * session : 0e1e4f7718566a1af438ba720f93058bc3e200dc
         * user_new : true
         */

        private String session;
        private boolean user_new;

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public boolean isUser_new() {
            return user_new;
        }

        public void setUser_new(boolean user_new) {
            this.user_new = user_new;
        }
    }
}
