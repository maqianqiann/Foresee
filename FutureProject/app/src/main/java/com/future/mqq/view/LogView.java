package com.future.mqq.view;

import com.future.mqq.bean.CodeBean;
import com.future.mqq.bean.LogBean;
import com.future.mqq.bean.SessionBean;

/**
 * Created by lenovo on 2017/5/27.
 */

public interface LogView {

    //获得注册的信息返回的session
    void showRegist(SessionBean sessionBean);
    void showLog(LogBean logBean);
    //注册验证返回的信息
    void showRegistData(CodeBean codeBean);


}
