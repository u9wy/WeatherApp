package com.weatherapp.weatherapi;

import com.weatherapp.weatherapi.api.ForecastService;
import com.weatherapp.weatherapi.interceptors.AdditionalInfoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ServiceGenerator {

    private static Retrofit.Builder getBaseRetrofit(String baseUrl){

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());
    }

    private static OkHttpClient getHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new AdditionalInfoInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    private static Retrofit getOpenWeatherMapForecastRetrofit(){

        return getBaseRetrofit(BaseUrls.BASE_OPEN_WEATHER_MAP_URL)
                .client(getHttpClient())
                .build();
    }

    public static ForecastService getForecastService(){
        return getOpenWeatherMapForecastRetrofit()
                .create(ForecastService.class);
    }

}
