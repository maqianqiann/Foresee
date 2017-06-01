package com.future.mqq.bean;

/**
 * Created by lenovo on 2017/5/28.
 */

public class LogBean {

    /**
     * data : {"message":"","session":"03ecb8841924e32bc30dc7176af6ddd2888389ea","user_role":0,"session_id":"03ecb8841924e32bc30dc7176af6ddd2888389ea","alert":false}
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
         * message :
         * session : 03ecb8841924e32bc30dc7176af6ddd2888389ea
         * user_role : 0
         * session_id : 03ecb8841924e32bc30dc7176af6ddd2888389ea
         * alert : false
         */

        private String message;
        private String session;
        private int user_role;
        private String session_id;
        private boolean alert;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public int getUser_role() {
            return user_role;
        }

        public void setUser_role(int user_role) {
            this.user_role = user_role;
        }

        public String getSession_id() {
            return session_id;
        }

        public void setSession_id(String session_id) {
            this.session_id = session_id;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }
    }
}
