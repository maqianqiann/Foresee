package com.emmiss.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hyphenate.easeui.ui.EaseContactListFragment;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/5/14 23:40
 */

public class ECConversationListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //会话列表
        ConversationListFragment conversationListFragment = new ConversationListFragment();
        //联系人列表
        EaseContactListFragment contactListFragment = new EaseContactListFragment();

        // 将参数传递给聊天界面
        conversationListFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.ec_layout_container, conversationListFragment).commit();
    }
}
