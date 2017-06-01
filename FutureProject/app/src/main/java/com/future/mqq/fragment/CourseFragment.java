package com.future.mqq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.future.mqq.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/23.
 */

public class CourseFragment extends Fragment {

    @Bind(R.id.course_title)
    TextView courseTitle;
    @Bind(R.id.course_rela)
    RelativeLayout courseRela;
    @Bind(R.id.course_recycle)
    RecyclerView courseRecycle;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_course, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
