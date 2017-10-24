package org.kylin.weiranweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hello on 2017/10/23.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;
    public Wind wind;
    public class More{
        @SerializedName("txt")
        public String info;
        public int code;

    }
    public class Wind{
        public String deg;
        public String dir;
        public String sc;
        public int spd;
    }
}
