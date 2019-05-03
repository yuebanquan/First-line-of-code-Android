package com.yuebanquan.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        //进行注册
//        registerReceiver(networkChangeReceiver, intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);    //获取实例

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent("com.yuebanquan.broadcasttest.MY_BROADCAST");
//                //标准广播
//                sendBroadcast(intent);

//                //有序广播
//                sendOrderedBroadcast(intent, null);

                //本地广播
                Intent intent = new Intent("com.yuebanquan.broadcasttest.LOCAL_BROADCAST") ;
                localBroadcastManager.sendBroadcast(intent);
            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("com.yuebanquan.broadcasttest.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);    //注册本地广播监听器
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        unregisterReceiver(networkChangeReceiver);
    }


    //动态注册全局广播
    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(context,"network changes", Toast.LENGTH_SHORT).show();
            //这是一个系统服务类，专门用于管理网络连接
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            //网络状态
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            //判断是否有网络
            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //动态注册本地广播
    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
