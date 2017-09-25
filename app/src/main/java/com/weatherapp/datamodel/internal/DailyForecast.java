package com.weatherapp.datamodel.internal;

import com.weatherapp.datamodel.external.Forecast;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DailyForecast {

    private List<Forecast> dailyforecastList;

    public List<Forecast> getDailyForecastList() {
        return dailyforecastList == null ? new ArrayList<Forecast>() : dailyforecastList;
    }

}
