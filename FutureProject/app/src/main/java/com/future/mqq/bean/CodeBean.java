package com.future.mqq.bean;

/**
 * Created by lenovo on 2017/5/28.
 */

public class CodeBean {

    /**
     * data : {"uname":"15711111111","login":true,"session":"316331e053ddd8c2fd9f2f7d63188bb14f168388","message":"测试弹窗","alert":true}
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
         * uname : 15711111111
         * login : true
         * session : 316331e053ddd8c2fd9f2f7d63188bb14f168388
         * message : 测试弹窗
         * alert : true
         */

        private String uname;
        private boolean login;
        private String session;
        private String message;
        private boolean alert;

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }
    }
}
