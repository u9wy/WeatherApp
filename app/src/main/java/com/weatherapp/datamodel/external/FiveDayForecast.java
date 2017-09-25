package com.weatherapp.datamodel.external;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FiveDayForecast {

    @SerializedName("list")
    private List<Forecast> forecastList;


    public List<Forecast> getForecastList() {
        return forecastList == null ?  new ArrayList<Forecast>() : forecastList;
    }

}
