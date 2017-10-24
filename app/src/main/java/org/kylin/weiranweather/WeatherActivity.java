package org.kylin.weiranweather;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.kylin.weiranweather.gson.Forecast;
import org.kylin.weiranweather.gson.Weather;
import org.kylin.weiranweather.util.HttpUtil;
import org.kylin.weiranweather.util.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";
    private ScrollView weatherLayout;
    private TextView titleCity;
    private TextView titleUpdateTime;
    private TextView degreeText;
    private TextView weatherInfoText;
    private LinearLayout forecastLayout;
    private TextView aqiText;
    private TextView pm25Text;
    private TextView comforText;
    private TextView carWashText;
    private TextView sportText;
private ImageView bgImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT>=21){
            View decorView =getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        //初始化各控件
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        titleCity = (TextView) findViewById(R.id.title_city);
        titleUpdateTime = (TextView) findViewById(R.id.title_update_time);
        degreeText = (TextView) findViewById(R.id.degree_text);
        weatherInfoText = (TextView) findViewById(R.id.weather_info_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        aqiText = (TextView) findViewById(R.id.aqi_text);
        pm25Text = (TextView) findViewById(R.id.pm25_text);
        comforText = (TextView) findViewById(R.id.comfort_text);
        carWashText = (TextView) findViewById(R.id.car_wash_text);
        sportText = (TextView) findViewById(R.id.sport_text);
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString =prefs.getString("weather",null);
        bgImg= (ImageView) findViewById(R.id.bg_img);
        String img=prefs.getString("bg_img",null);
        if (img!=null){
            Glide.with(this).load(img).into(bgImg);
        }else {
            loadbgImg();
        }
        if (weatherString!=null){
            //有缓存时直接解析天气数据
            Weather weather = Utility.handleWeatherResponse(weatherString);
            Log.d(TAG, "weather: weather.toString();"+weather.forecastlist.get(0).getDate());
//            Log.d(TAG, "weather: getTxt;"+weather.suggestion.getSuggestion().getComf().getTxt());
//            String comfort="舒适度："+weather.suggestion.getSuggestion().getComf().getTxt();

            Log.d(TAG, "weather: getTxt;"+weather.suggestion.comf.brf);
            Log.d(TAG, "weather: getTxt;"+weather.suggestion.comf.txt);
            String comfort="舒适度："+weather.suggestion.cw.txt;
            Log.d(TAG, "weather: comfort ;"+comfort);
//            String carWash="洗车指数："+weather.suggestion.getSuggestion().getCw().getTxt();

            showWeatherInfo(weather);
        }else {
            //无缓存时去服务器查询天气
            String weatherId =getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);
        }
    }

    /**
     * 加载天气背景图
     */
    private void loadbgImg() {
        String requestImg="http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkhttpRequest(requestImg, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String img=response.body().string();
                SharedPreferences.Editor editor =PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bg_img",img);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(img).into(bgImg);
                    }
                });
            }
        });
    }

    private void requestWeather(final String weatherId) {
        Log.d(TAG, "requestWeather:weatherId: "+weatherId);
        String weatherUrl = "http://guolin.tech/api/weather?cityid="+weatherId+"&key=ee80d46ea2034d1c9146e36e67a3d074";
        HttpUtil.sendOkhttpRequest(weatherUrl, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText=response.body().string();
                Log.d(TAG, "onResponse: "+responseText);
                final Weather weather =Utility.handleWeatherResponse(responseText);
                Log.d(TAG, "onResponse: weather:"+weather.status);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(weather!=null &&"ok".equals(weather.status)){
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather",responseText);
                            editor.apply();
                            showWeatherInfo(weather);

                        }else{
                            Toast.makeText(WeatherActivity.this,"获取天气信息失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this,"获取天气信息失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });

    }

    /**
     * 处理并展示 Weather 实体类中的数据
     * @param weather
     */
    private void showWeatherInfo(Weather weather) {
        String cityName =weather.basic.cityName;
        String updateTime ="更新时间："+weather.basic.update.updateTime.split(" ")[1];
//        String updateTime =weather.basic.update.updateTime;
        Log.d(TAG, "showWeatherInfo: updateTime:"+updateTime);
        String degree =weather.now.temperature+"℃";
        String weatherInfo =weather.now.more.info;
        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
        forecastLayout.removeAllViews();
        for (Forecast forecast  :weather.forecastlist){
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item,forecastLayout,false);
            TextView dataText =(TextView)view.findViewById(R.id.date_text);
            TextView infoText =(TextView)view.findViewById(R.id.info_text);
            TextView maxText =(TextView)view.findViewById(R.id.max_text);
            TextView minText =(TextView)view.findViewById(R.id.min_text);
            dataText.setText(forecast.getDate());
            Log.d(TAG, "showWeatherInfo: forecast.getDate() "+forecast.getDate());
            infoText.setText(forecast.getCond().getTxt_d());
            Log.d(TAG, "showWeatherInfo: forecast.getTxt_d() "+forecast.getCond().getTxt_d());
            maxText.setText(forecast.getTmp().getMax());
            minText.setText(forecast.getTmp().getMin());
            forecastLayout.addView(view);
        }
        if (weather.aqi!=null){
            aqiText.setText(weather.aqi.city.aqi);
            pm25Text.setText(weather.aqi.city.pm25);
        }
        String comfort="舒适度："+weather.suggestion.comf.txt;
        String carWash="洗车指数："+weather.suggestion.cw.txt;
        String sport="洗车指数："+weather.suggestion.sport.txt;
        comforText.setText(comfort);
        carWashText.setText(carWash);
        sportText.setText(sport);
        weatherLayout.setVisibility(View.VISIBLE);

    }
}
