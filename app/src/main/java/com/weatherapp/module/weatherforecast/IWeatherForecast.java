package com.weatherapp.module.weatherforecast;

import java.util.List;

public interface IWeatherForecast {

    interface Presenter {

    }

    interface View {

        void showError();

        void showList(List<Object> adapterInfo);

    }

}
