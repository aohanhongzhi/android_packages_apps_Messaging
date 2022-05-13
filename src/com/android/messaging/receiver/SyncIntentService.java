package com.android.messaging.receiver;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.android.messaging.util.LogUtil;


import java.util.List;

public class SyncIntentService extends IntentService {

    public SyncIntentService() {
        super("子线程名字");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Bundle extras = intent.getExtras();
        String msg = extras.getString("msg");

        LogUtil.i(TAG, "子服务里面处理消息" + msg);
        String result = HttpClient.doGet("http://easyprint.vip:9090/api/dingtalk/v1/notice?msg=" + msg)
        LogUtil.i(TAG, "百度请求信息: \n" + result);
    }
}
