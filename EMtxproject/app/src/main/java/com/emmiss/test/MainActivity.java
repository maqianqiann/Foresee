package com.emmiss.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.ec_edit_chat_id)
    EditText ecEditChatId;
    @Bind(R.id.ec_btn_start_chat)
    Button ecBtnStartChat;
    @Bind(R.id.ec_btn_sign_out)
    Button ecBtnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!EMClient.getInstance().isLoggedInBefore()) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //点击事件
        initView();


    }

    private void initView() {
        ecBtnStartChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取我们发起聊天的者的username
                String chatId = ecEditChatId.getText().toString().trim();
                if (!TextUtils.isEmpty(chatId)) {
                    // 获取当前登录用户的 username
                    String currUsername = EMClient.getInstance().getCurrentUser();
                    if (chatId.equals(currUsername)) {
                        Toast.makeText(MainActivity.this, "不能和自己聊天", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // 跳转到聊天界面，开始聊天
                    Intent intent = new Intent(MainActivity.this, ECConversationListActivity.class);
                    // EaseUI封装的聊天界面需要这两个参数，聊天者的username，以及聊天类型，单聊还是群聊
                    intent.putExtra("userId", chatId);
                    intent.putExtra("chatType", EMMessage.ChatType.Chat);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Username 不能为空", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
