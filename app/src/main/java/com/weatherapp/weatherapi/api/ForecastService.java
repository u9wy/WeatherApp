package com.weatherapp.weatherapi.api;

import com.weatherapp.datamodel.external.FiveDayForecast;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ForecastService {

    @POST("data/2.5/forecast")
    Call<FiveDayForecast> getFiveDayForecast(@Query("q") String city);

}
