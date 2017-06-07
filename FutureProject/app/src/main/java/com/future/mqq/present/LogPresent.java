package com.future.mqq.present;

import android.content.Context;

import com.future.mqq.bean.CodeBean;
import com.future.mqq.bean.LogBean;
import com.future.mqq.bean.SessionBean;
import com.future.mqq.model.LogModel;
import com.future.mqq.model.MyLogModel;
import com.future.mqq.view.LogView;

/**
 * Created by lenovo on 2017/5/27.
 * 这是获得登陆和注册信息的P层
 */

public class LogPresent {
    private LogView view;
    private LogModel model;
    private Context context;

    public LogPresent(LogView view,Context context) {
        this.view = view;
        model=new MyLogModel();
        this.context=context;

    }

    //写个获得注册的方法返回的seesion
    public void getRegist(String mobile){
        model.getRegistData(new LogModel.OnRegistListener() {
            @Override
            public void getRegist(SessionBean sessionBean) {
                view.showRegist(sessionBean);
            }
        },context,mobile);
    }

    //写个获取验证码之后，进行效验验证
    public void getRegistData(String session,int rand,String passwd){
          model.getRegistCode(new LogModel.OnRegCodeListener() {
              @Override
              public void getRegist1(CodeBean codeBean) {
                  view.showRegistData(codeBean);

              }
          },context,session,rand,passwd);

    }

    public void getLogDatas(String mobile,String pwd){
          model.getLogData(new LogModel.OnLogListener() {
              @Override
              public void geLog(LogBean logBean) {

                  //拿到数据,给View
                  view.showLog(logBean);

              }
          },context,mobile,pwd);
    }
}
