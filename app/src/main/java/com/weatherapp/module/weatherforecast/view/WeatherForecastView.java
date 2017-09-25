package com.weatherapp.module.weatherforecast.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.weatherapp.R;
import com.weatherapp.module.weatherforecast.IWeatherForecast;
import com.weatherapp.module.weatherforecast.view.adapters.MainAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeatherForecastView extends LinearLayout implements IWeatherForecast.View {

    @BindView(R.id.recyclerView_main)
    protected RecyclerView recyclerView;

    private MainAdapter adapter;

    public WeatherForecastView(Context context) {
        super(context);
        initiate();
    }

    public WeatherForecastView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initiate();
    }

    public WeatherForecastView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initiate();
    }

    public WeatherForecastView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initiate();
    }

    private void initiate() {
        inflate(getContext(),R.layout.view_weather_forecast,this);
        ButterKnife.bind(this);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.Error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List<Object> adapterInfo) {
        adapter = new MainAdapter(adapterInfo);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
