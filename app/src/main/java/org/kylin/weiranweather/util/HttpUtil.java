package org.kylin.weiranweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by hello on 2017/10/22.
 */

public class HttpUtil {

    public static void  sendOkhttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client =new OkHttpClient();
        Request request =new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
