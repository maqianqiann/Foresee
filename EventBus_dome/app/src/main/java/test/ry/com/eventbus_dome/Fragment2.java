package test.ry.com.eventbus_dome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by lenovo on 2017/5/18.
 */

public class Fragment2 extends Fragment {

    private View view;

    private LinearLayout linear;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f2_layout, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        linear = (LinearLayout) view.findViewById(R.id.f2_linear);

       //  text= (TextView) view.findViewById(R.id.text_l);
       //设置点击事件
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsBean newsBean =new NewsBean("sasasasasa");
                //进行传值
                EventBus.getDefault().postSticky(newsBean);
                EventBus.getDefault().post("");

                Intent in=new Intent(getActivity(),NextActivity.class);
                startActivity(in);
            }
        });


    }
    @Subscribe (threadMode = ThreadMode.MAIN)
    public void MessageEvent(User user){
        TextView   text = new TextView(getActivity());
        String name = user.getName();
        text.setText(name);
        linear.addView(text);

    }
    @Override
    public void onStart() {
        super.onStart();
        //注册
        EventBus.getDefault().register(this);
    }

    /*@Override
    public void onDestroy() {
        super.onDestroy();
        //去小区注册
        EventBus.getDefault().unregister(this);
    }*/

    //让其在失去焦点的时候就进行取消注册，不然回到这个界面的时候，又会再次注册导致报错。
    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}
