package com.future.mqq.wxpay;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.future.mqq.R;
import com.tencent.mm.sdk.constants.Build;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import org.json.JSONObject;

public class PayActivity1 extends Activity {
	
	private IWXAPI api;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pay);
		 //注册微信
        IWXAPI msgApi = WXAPIFactory.createWXAPI(this, Constants.APP_ID);
        msgApi.registerApp(Constants.APP_ID);
	/*	api = WXAPIFactory.createWXAPI(this, "wxb4ba3c02aa476ea1");*/


		Button appayBtn = (Button) findViewById(R.id.appay_btn);
		appayBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String url = "http://wxpay.weixin.qq.com/pub_v2/app/app_pay.php?plat=android";
			  //final String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";//POST请求统一下单接口地址
				//private String notify_url = "http://www.weixin.qq.com/wxpay/pay.php";
				Button payBtn = (Button) findViewById(R.id.appay_btn);
				payBtn.setEnabled(false);
				Toast.makeText(PayActivity1.this, "获取订单中...", Toast.LENGTH_SHORT).show();
		        try{
					byte[] buf = Util.httpGet(url);
					if (buf != null && buf.length > 0) {
						String content = new String(buf);
						Log.e("get server pay params:",content);
			        	JSONObject json = new JSONObject(content); 
						if(null != json && !json.has("retcode") ){
							PayReq req = new PayReq();
							//req.appId = "wxf8b4f85f3a794e77";  // ������appId
							req.appId			= json.getString("appid");
							req.partnerId		= json.getString("partnerid");
							req.prepayId		= json.getString("prepayid");
							req.nonceStr		= json.getString("noncestr");
							req.timeStamp		= json.getString("timestamp");
							req.packageValue	= json.getString("package");
							req.sign			= json.getString("sign");
							req.extData			= "app data"; // optional
							Toast.makeText(PayActivity1.this, "正常调起支付", Toast.LENGTH_SHORT).show();
							api.sendReq(req);
						}else{
							Log.d("PAY_GET", "返回错误"+json.getString("retmsg"));
				        	Toast.makeText(PayActivity1.this, ""+json.getString("retmsg"), Toast.LENGTH_SHORT).show();
						}
					}else{
						Log.d("PAY_GET", "服务器请求错误");
			        	Toast.makeText(PayActivity1.this, "服务器请求错误", Toast.LENGTH_SHORT).show();
			        }
		        }catch(Exception e){
		        	Log.e("PAY_GET", "Pay_get"+e.getMessage());
		        	Toast.makeText(PayActivity1.this, "�错误信息�"+e.getMessage(), Toast.LENGTH_SHORT).show();
		        }
		        payBtn.setEnabled(true);
			}
		});		
		Button checkPayBtn = (Button) findViewById(R.id.check_pay_btn);
		checkPayBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boolean isPaySupported = api.getWXAppSupportAPI() >= Build.PAY_SUPPORTED_SDK_INT;
				Toast.makeText(PayActivity1.this, String.valueOf(isPaySupported), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
}
