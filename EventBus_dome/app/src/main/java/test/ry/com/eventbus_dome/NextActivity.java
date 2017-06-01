package test.ry.com.eventbus_dome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by lenovo on 2017/5/19.
 */
public class NextActivity extends AppCompatActivity{

    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_layout);

        text = (TextView) findViewById(R.id.text_next);

        //接收传过来的值

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }
    @Subscribe(threadMode = ThreadMode.POSTING,priority = 1,sticky = true)
    public void nextMessage1(NewsBean newsBean){
        text.setText(newsBean.getTitle());
        Log.i("nextMessage1",newsBean.getTitle());

    }

    @Subscribe(threadMode = ThreadMode.POSTING,priority = 5,sticky = true)
    public void nextMessage2(NewsBean newsBean){
    //    text.setText(newsBean.getTitle());
        Log.i("nextMessage2",newsBean.getTitle());

    }

    @Subscribe(threadMode = ThreadMode.POSTING,priority = 10,sticky = true)
    public void nextMessage3(NewsBean newsBean){
      //  text.setText(newsBean.getTitle());
        Log.i("nextMessage3",newsBean.getTitle());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       //去取消注册
        EventBus.getDefault().unregister(this);
    }
}
