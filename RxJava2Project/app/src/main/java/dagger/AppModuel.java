package dagger;

import android.content.Context;

/**
 * Created by lenovo on 2017/5/15.
 * 这是父容器，提供上下文,用来提供实例的对象
 */

@Module
public class AppModuel {

    private Context context;

    public AppModuel(Context context) {
        this.context = context;
    }

    @Provides
    Context contextProvides(){
        return context;
    }


}
