package com.weatherapp.datamodel.external;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Main {

    @SerializedName("temp")
    @Expose
    private double temp;

    @SerializedName("temp_min")
    @Expose
    private double tempMin;

    @SerializedName("temp_max")
    @Expose
    private double tempMax;

    @SerializedName("pressure")
    @Expose
    private double pressure;

    @SerializedName("sea_level")
    @Expose
    private double seaLevelPressure;

    @SerializedName("grnd_level")
    @Expose
    private double groundLevelPressure;

    @SerializedName("humidity")
    @Expose
    private int humidityPercentage;

    @SerializedName("temp_kf")
    @Expose
    private double tempKf;

}
