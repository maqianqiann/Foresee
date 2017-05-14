package com.rxjava.test.present;




import com.rxjava.test.bean.NewsBean;
import com.rxjava.test.bean.UserBean;
import com.rxjava.test.utils.MainModer;
import com.rxjava.test.utils.MyListModel1;
import com.rxjava.test.utils.MyModel;
import com.rxjava.test.utils.MyModel1;
import com.rxjava.test.view.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/12.
 */

public class MyPresent {
    //获得Model的对象
    private MyListView view;

    MyModel myModel;
    public MyPresent(MyListView view) {
        //创建view对象
        this.view=view;
    }


    //创建加载数据的方法
    public void french(){
          myModel= new MainModer();
        if(myModel!=null){

            myModel.getDatasModel(new MyModel.OnRxJavaLisener() {
                @Override
                public void complete(ArrayList<UserBean> list) {
                      view.getListData(list);
                }
            });
        }

        }

}
