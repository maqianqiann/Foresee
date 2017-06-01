package com.future.mqq.model;

import android.content.Context;

import com.future.mqq.bean.CodeBean;
import com.future.mqq.bean.LogBean;
import com.future.mqq.bean.SessionBean;

/**
 * Created by lenovo on 2017/5/27.
 * 这是登陆和注册的model层
 */

public interface LogModel {

    void getRegistData(OnRegistListener onRegistListener, Context context,String mobile);
    //定义内部的接口
    interface OnRegistListener{
        void getRegist(SessionBean sessionBean);
    }

    void getLogData(OnLogListener onLogListener,Context context,String mobile,String pwd);
    //定义内部的接口
    interface OnLogListener{
        void geLog(LogBean logBean);
    }
    void getRegistCode(OnRegCodeListener onRegCodeListener, Context context, String session,int rand,String passwd);
    //定义内部的接口
    interface OnRegCodeListener{
        void getRegist1(CodeBean codeBean);
    }



}
