package com.thread.test;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * Created by lenovo on 2017/5/23.
 */

public class NextActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

    }

    private void getAsytask(){

        MyAsytask task=new MyAsytask();
        task.execute();
    }

    private class MyAsytask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}
