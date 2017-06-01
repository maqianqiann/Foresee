package test.ry.com.eventbus_dome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.greenrobot.event.EventBus;


/**
 * Created by lenovo on 2017/5/18.
 */

public class Fragment1 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1_layout, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view.findViewById(R.id.button_l).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进行传值
                EventBus.getDefault().post(new User("天气好热~~~"));

            }
        });
        EventBus.getDefault().post("");
        EventBus.getDefault().registerSticky("");
    }


}
