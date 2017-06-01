package com.thread.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.RandomAccessFile;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class MainActivity extends Activity {

    private String string;
    private final static int threadsize = 3;
    private ProgressBar pro;
    private TextView info;
    private Button pause;
    private boolean flag = false;//是否在下载
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SET_MAX:
                    //设置最大值
                    int length= (int) msg.obj;
                    pro.setMax(length);

                    break;
                case UPDATE_VIEW:
                     int progress= (int) msg.obj;
                    pro.setProgress(progress+pro.getProgress());

                    //获取百分比设置给text
                    int max = pro.getMax();
                    int i = pro.getProgress();
                    int result=(i*100)/max;
                    info.setText("下载： "+result+"%");

                    break;
            }
        }
    };

    protected static final int SET_MAX = 0;
    public static final int UPDATE_VIEW = 1;
    private Button down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //获得服务器的图片
        string = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495040157701&di=e75c9d745a6af178d07e3e3b78e3cb3b&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fwallpaper%2F1502%2F03%2Fc0%2F2703334_1422958313278_800x600.jpg";

        down = (Button) findViewById(R.id.bt_download);
        pro = (ProgressBar) findViewById(R.id.progress);
        pause = (Button) findViewById(R.id.bt_pause);
        info = (TextView) findViewById(R.id.tv_info);

    }
    //写点击事件的方法
    public void download(View view){
        flag = true;
        down.setEnabled(false);
        pause.setEnabled(true);
        getFile();


    }
    public void pause(View v){
        flag = false;
        down.setEnabled(true);
        pause.setEnabled(false);
    }



    //开启子线程进行获取服务器的文件的大小
      private void getFile(){

          //开启子线程
          new Thread(new Runnable() {
              @Override
              public void run() {
            HttpClient client = new DefaultHttpClient();
                  //创建请求头
                  HttpHead head=new HttpHead(string);
                  //执行请求
                  try {
                      HttpResponse response = client.execute(head);
                      int statusCode = response.getStatusLine().getStatusCode();
                      Log.i("xxxx",statusCode+"");
                      //判断响应码
                      if(response.getStatusLine().getStatusCode()==200){

                          Header[] headers = response.getHeaders("Content-Length");
                          //获得大小,转换为int类型
                          String value = headers[0].getValue();
                          int parseInt = Integer.parseInt(value);
                          //这是文件的大小
                          Log.i("xxx",parseInt+"");
                          //给进度条
                          //发送消息给进度条
                          Message message = Message.obtain(handler, SET_MAX, parseInt);
                          message.sendToTarget();


                          //2.在sd卡创建与服务器文件大小一样的文件
                          String name = openFileName(string);
                          File file=new File(Environment.getExternalStorageDirectory(),name);
                          //随机访问文件
                          RandomAccessFile raf=new RandomAccessFile(file,"rwd");
                          //设置文件的大小
                          raf.setLength(parseInt);
                          //关闭
                          raf.close();
                          //计算每条线程的下载量
                          int block=(parseInt%threadsize==0)?(parseInt/threadsize):(parseInt/threadsize+1);
                          //开启三条线程进行下载
                          for (int i = 0; i <threadsize; i++) {

                              //创建下载的类
                              new LoadMyDatas(string,i,file,block).start();


                          }

                      }

                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }
          }).start();


      }

    //获得文件的名称
    public  String openFileName(String uri){
        return uri.substring(uri.lastIndexOf("/")+1);
    }

    //创建下载的类,继承线程Thread
    private class LoadMyDatas extends Thread{
          //线程下载的地址
        private String uri;
        private int threadId;//下载的ip
        //下载的文件
        private File file;
        //下载的块
        private int block;
        //开始的位置和结束的位置
        private int start;
        private int end;



        public LoadMyDatas(String uri, int threadId, File file, int block) {
            this.uri = uri;
            this.threadId = threadId;
            this.file = file;
            this.block = block;
            //开始的位置
            start=threadId*block;
            end=(threadId+1)*block-1;

        }
        //开始下载

        @Override
        public void run() {
            super.run();
            //随机访问的文件
            try {
                RandomAccessFile raf=new RandomAccessFile(file,"rwd");
                HttpClient client=new DefaultHttpClient();
                HttpGet request=new HttpGet(uri);
                request.addHeader("Range", "bytes:"+start+"-"+end);//添加请求头
                //进行网络请求
                HttpResponse response = client.execute(request);
                if(response.getStatusLine().getStatusCode()==200){
                    InputStream stream = response.getEntity().getContent();
                    //将读取的内容写到文件
                    byte[] bytes=new byte[1024];
                    int len=0;
                    while ((len=stream.read(bytes))!=-1){
                        if(!flag){
                            //如果暂停下载   就直接return
                            return;//标准线程结束
                        }

                        raf.write(bytes,0,len);
                        //读取原来的下载量
                        int readDatas = readDatas(threadId);
                        //计算新的下载量
                        int newDatas=readDatas+len;
                        //更新新的下载记录
                        updateDatas(threadId,newDatas);

                        //更新进度条
                        Message message = Message.obtain(handler, UPDATE_VIEW, newDatas);
                        message.sendToTarget();


                    }
                    raf.close();
                    stream.close();
                    Log.i("xxxx",threadId+"第几");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }



        }
        //读取线程的数据
        private int readDatas(int threadId){
            int in =0;
            File file=new File(Environment.getExternalStorageDirectory(),threadId+"/.txt");
            //使用ButterReader
            try {
                BufferedReader reader=new BufferedReader(new FileReader(file));
                //按行读取
                String line = reader.readLine();

                if(TextUtils.isEmpty(line)){
                    //如果不为空
                    in = Integer.parseInt(line);

                }
                  //关流
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


            return  in;
        }

    }

    private void updateDatas(int threadId,int newDatas){
        File file=new File(Environment.getExternalStorageDirectory(),threadId+"/.txt");
        try {
            FileWriter fw=new FileWriter(file);
            fw.write(newDatas+"");
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
