package com.emmiss.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.ui.EaseContactListFragment;

public class ECChatActivity extends AppCompatActivity {

    // 当前聊天的 ID
    private String mChatId;
    private EaseChatFragment chatFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chat);

        // 这里直接使用EaseUI封装好的聊天界面
        chatFragment = new EaseChatFragment();
        //会话列表
        ConversationListFragment conversationListFragment = new ConversationListFragment();
        //联系人列表
        EaseContactListFragment contactListFragment = new EaseContactListFragment();

        // 将参数传递给聊天界面
        chatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.ec_layout_container, chatFragment).commit();

        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
