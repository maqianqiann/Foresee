package com.future.mqq.present;

import android.content.Context;

import com.future.mqq.model.FirstModel;
import com.future.mqq.utils.ModelUtils;
import com.future.mqq.view.FirstView;

/**
 * Created by lenovo on 2017/5/31.
 * 这是第一次握手时使用的
 */

public class FirstPresent {

      FirstModel model=null;
     FirstView view=null;
    Context context=null;

    public FirstPresent(FirstView view, Context context) {
        this.view = view;
        this.context=context;
        model=new FirstModel(this,context);

    }

    public void getFirst(Boolean boo){
             view.showFirst(boo);
    }


    //调用model 的方法
    public void getModelDatas(){
        model.firstHand(ModelUtils.APPTYPE,ModelUtils.getLocaldeviceId(context),ModelUtils.getVer_code(context),ModelUtils.getTick());
    }

}
