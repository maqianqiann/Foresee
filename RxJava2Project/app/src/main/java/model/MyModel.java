package model;

import bean.NewsBean;
import io.reactivex.Flowable;

/**
 * Created by lenovo on 2017/5/15.
 * 这是逻辑操作的层，需要进行各种逻辑的操作
 */

public interface MyModel {
    //提供网络请求的获得数据的方法
    void getNewsBean();
    //写个获得Flowable对象的方法
    Flowable<NewsBean> getDatas(String name);

   /* void getOnDatas(DatasLinener datasLinener);
      interface  DatasLinener{
          void getShu(ArrayList<NewsBean> list);
      }*/
}
