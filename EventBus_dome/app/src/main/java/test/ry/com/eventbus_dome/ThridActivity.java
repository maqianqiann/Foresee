package test.ry.com.eventbus_dome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by lenovo on 2017/5/19.
 */

public class ThridActivity extends AppCompatActivity {

    private String string;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_layout);
        string = "hello,my baby";

        initAES();

    }

    private void initAES() {
        //生成Key
        try {
            KeyGenerator key=KeyGenerator.getInstance("AES");
            //初始化key,c长度
            key.init(128);
            SecretKey secretKey = key.generateKey();
            //生成key的内容，编码
            byte[] bytes = secretKey.getEncoded();
            //key的转换
            Key keys=new SecretKeySpec(bytes,"AES");


            //加密,加密方式，工作模式.填充方式，
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //初始化key是以加密的方式
            cipher.init(Cipher.ENCRYPT_MODE,keys);
            //获得加密后的数组
            byte[] aFinal = cipher.doFinal(string.getBytes());
            //加密成base64位的模式
            Log.i("xxxxa",Base64.encodeToString(aFinal,0));

            //进行解密,DECRYPT_MODE解密的模式，将解密的keys重新初始化
            cipher.init(Cipher.DECRYPT_MODE,keys);
            aFinal= cipher.doFinal(aFinal);
            Log.i("xxxxa",new String(aFinal));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
