package com.ry.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.Conversation;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button person;
    private Button chat;
    private ArrayList<FragmentActivity> listf=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        viewPager = (ViewPager) findViewById(R.id.viewPager_man);
        chat = (Button) findViewById(R.id.button_chat);
        person = (Button) findViewById(R.id.button_person);
       ConversationListActivity cl=new ConversationListActivity();
        ConversationActivity ca=new ConversationActivity();
        listf.add(ca);
        listf.add(cl);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startPrivateChat(MainActivity.this,"2","ABC");
            }
        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startConversationList(MainActivity.this);
            }
        });
        findViewById(R.id.button_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startSubConversationList(MainActivity.this, Conversation.ConversationType.PRIVATE);
            }
        });



    }

    private class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return listf.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            FragmentActivity activity = listf.get(position);
       //     container.addView(activity);

            return activity;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    }



}
