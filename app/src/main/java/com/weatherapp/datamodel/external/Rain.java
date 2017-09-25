package com.weatherapp.datamodel.external;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class Rain {

    /**
     * Rain in the last 3 hours in mm
     */

    @SerializedName("3h")
    private double rainInLastThreeHours;

}
