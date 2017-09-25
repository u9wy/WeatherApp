package com.weatherapp.weatherapi.interceptors;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AdditionalInfoInterceptor implements Interceptor {

    private static final String API_PARAM_VAR = "appid=";
    private static final String API_KEY = "283799e34bda3908a5c1e6cf7288926b";

    private static final String UNIT_PARAM_VAR = "units=";
    private static final String METRIC_UNIT = "metric";

    private static final String APPEND = "&";

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request originalRequest = chain.request();

        Request.Builder requestBuilder = originalRequest.newBuilder();
        requestBuilder.url(originalRequest.url() +
                            APPEND + UNIT_PARAM_VAR + METRIC_UNIT +
                            APPEND + API_PARAM_VAR + API_KEY);


        return chain.proceed(requestBuilder.build());
    }

}
