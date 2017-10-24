package org.kylin.weiranweather.gson;

/**
 * Created by hello on 2017/10/23.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
        public String pm10;
        public String no2;
        public String qlty;
    }
}
