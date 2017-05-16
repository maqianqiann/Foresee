package dagger;

import present.MyPresent;

/**
 * Created by lenovo on 2017/5/15.
 * 这是子桥梁
 *
 */
@Component (modules = MyModuel.class)
public interface MyComonent {

    //进行注入
    void  inject(MyPresent present);

}
