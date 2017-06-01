package com.future.mqq.bean;

/**
 * Created by lenovo on 2017/6/1.
 */

public class PayBean {

    public int ret;
    public Datas data;

    public class Datas{
        int pay_type;
        int pass_to_pay;
        String order_id;
        String msg;

        @Override
        public String toString() {
            return "Datas{" +
                    "pay_type=" + pay_type +
                    ", pass_to_pay=" + pass_to_pay +
                    ", order_id='" + order_id + '\'' +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

}
