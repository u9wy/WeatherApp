package com.weatherapp.datamodel.external;


import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Wind {

    @SerializedName("speed")
    private double speed;

    @SerializedName("deg")
    private double degrees;

}
