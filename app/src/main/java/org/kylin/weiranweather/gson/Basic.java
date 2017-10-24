package org.kylin.weiranweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hello on 2017/10/23.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    @SerializedName("update")
    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
