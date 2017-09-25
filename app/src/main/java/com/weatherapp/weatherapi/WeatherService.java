package com.weatherapp.weatherapi;

import com.weatherapp.datamodel.external.FiveDayForecast;
import com.weatherapp.datamodel.external.Forecast;
import com.weatherapp.weatherapi.api.ForecastService;
import com.weatherapp.weatherapi.listeners.ResponseListener;
import com.weatherapp.weatherapi.listeners.RetrofitCallback;

/**
 * Created by Xpieon on 25/09/2017.
 */

public class WeatherService {

    private ForecastService forecastService;

    public WeatherService(){
        forecastService = ServiceGenerator.getForecastService();
    }

    public void getFiveDayForecast(String city,ResponseListener<FiveDayForecast> listener) {
        forecastService.getFiveDayForecast(city).enqueue(new RetrofitCallback<>(listener));
    }
}
