package com.weatherapp.datamodel.external;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Clouds {

    @SerializedName("all")
    private int cloudPercentage;

}
