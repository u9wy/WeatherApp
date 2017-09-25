package com.weatherapp.datamodel.external;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import lombok.Data;
import lombok.Getter;

@Getter
public class Forecast {

    @SerializedName("main")
    private Main main;

    @SerializedName("weather")
    private List<Weather> weatherList;

    @SerializedName("clouds")
    private Clouds clouds;

    @SerializedName("wind")
    private Wind wind;

    @SerializedName("rain")
    private Rain rain;

    @SerializedName("snow")
    private Snow snow;

    @SerializedName("dt_txt")
    private String dateTime;


    public Weather getWeather(){
        return weatherList == null || weatherList.isEmpty() ? new Weather() : weatherList.get(0);
    }

    public Date getDateTime(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        Date date;
        try {
            date = format.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return date;
    }

}
