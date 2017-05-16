package dagger;

import model.MyModelC;

/**
 * Created by lenovo on 2017/5/15.
 * 这是子容器，需要哪个返回的对象就返回哪个
 */
@Module
public class MyModuel {


    /*@Provides
     MyRetrofit getRetrofit(){

      return new MyRetrofit();
     }
*/

    @Provides
    MyModelC showModel(){
        return new MyModelC();
    }


   /* @Provides
    Context context(){
        return context();
    }
*/
}
