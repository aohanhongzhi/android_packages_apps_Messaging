package com.android.messaging.receiver;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;
import android.os.Bundle;
import com.android.messaging.util.LogUtil;


import java.util.List;

public class SyncIntentService extends IntentService {
    private static final String TAG = LogUtil.BUGLE_TAG;
    public SyncIntentService() {
        super("子线程名字");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Bundle extras = intent.getExtras();
        String msg = extras.getString("msg");
        try{
            LogUtil.i(TAG, "子服务里面处理消息=>" + msg);
            String result = HttpClient.doGet("http://easyprint.vip:9090/api/dingtalk/v1/notice?title=转发短信&msg="+msg);
            LogUtil.i(TAG, "请求服务器结果信息: \n" + result);
        }catch(Exception e){
            LogUtil.e(TAG, "请求到服务器失败: \n");
        }

    }
}
