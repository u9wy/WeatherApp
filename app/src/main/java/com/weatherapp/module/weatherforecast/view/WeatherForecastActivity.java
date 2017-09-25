package com.weatherapp.module.weatherforecast.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.weatherapp.module.weatherforecast.IWeatherForecast;
import com.weatherapp.module.weatherforecast.presenter.WeatherForecastPresenter;

public class WeatherForecastActivity extends AppCompatActivity {

    private WeatherForecastView view;
    private IWeatherForecast.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new WeatherForecastView(this);
        presenter = new WeatherForecastPresenter(view);
        view.setPresenter(presenter);
        setContentView(view);

    }
}
