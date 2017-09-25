package com.weatherapp.module.weatherforecast.presenter;

import com.weatherapp.util.DateTimeUtil;
import com.weatherapp.datamodel.external.FiveDayForecast;
import com.weatherapp.datamodel.external.Forecast;
import com.weatherapp.datamodel.internal.DailyForecast;
import com.weatherapp.datamodel.internal.Header;
import com.weatherapp.module.weatherforecast.IWeatherForecast;
import com.weatherapp.weatherapi.WeatherService;
import com.weatherapp.weatherapi.listeners.ResponseListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Response;

public class WeatherForecastPresenter implements IWeatherForecast.Presenter {

    private List<Object> adapterInfo;
    private WeatherService weatherService;

    private IWeatherForecast.View view;

    public WeatherForecastPresenter(IWeatherForecast.View view){
        this.view = view;
        weatherService = new WeatherService();
        getForecast();
    }

    private void getForecast(){
        weatherService.getFiveDayForecast("London", new ResponseListener<FiveDayForecast>() {
            @Override
            public void onSuccess(Response<FiveDayForecast> response) {
                prepareInfo(response.body());
                view.showList(adapterInfo);
            }

            @Override
            public void onUnauthorised() {
                view.showError();
            }

            @Override
            public void onError(Throwable throwable) {
                view.showError();
                throwable.printStackTrace();
            }

            @Override
            public void onServerError(int errorCode, String message) {
                view.showError();
            }
        });
    }

    /**
     * Structures the data so it can be passed to the adapter and displayed
     * @param fiveDayForecast forecast objects received from the webservice
     */

    private void prepareInfo(FiveDayForecast fiveDayForecast){

        List<DailyForecast> dailyForecasts = new ArrayList<>();

        adapterInfo = new ArrayList<>();

        Calendar calendar = null;

        for(int i = 0; i < fiveDayForecast.getForecastList().size(); i++){

            Forecast forecast = fiveDayForecast.getForecastList().get(i);

            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTimeInMillis(forecast.getDateTime().getTime());
            
            if(i == 0){
                calendar = currentCalendar;
                dailyForecasts.add(DailyForecast.builder()
                .dailyforecastList(new ArrayList<Forecast>())
                .build());
            } else if (calendar.get(Calendar.DAY_OF_YEAR) != currentCalendar.get(Calendar.DAY_OF_YEAR)){
                calendar = currentCalendar;
                dailyForecasts.add(DailyForecast.builder()
                        .dailyforecastList(new ArrayList<Forecast>())
                        .build());
            }

            dailyForecasts.get(dailyForecasts.size()-1).getDailyForecastList().add(forecast);

        }

        for(int i = 0; i < dailyForecasts.size(); i++){

            DailyForecast forecast = dailyForecasts.get(i);

            adapterInfo.add(Header.builder()
                    .headerName(DateTimeUtil.getDay(forecast.getDailyForecastList().get(0).getDateTime())).build());

            adapterInfo.add(forecast);
        }

    }
}
