package app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import utils.ImageLoaderConfig;

/**
 * Created by lenovo on 2017/5/15.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    //初始化控件
        Fresco.initialize(this, ImageLoaderConfig.getImagePipelineConfig(this));

    }
}
