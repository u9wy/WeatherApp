package com.weatherapp.weatherapi.listeners;

import retrofit2.Response;

public interface ResponseListener<T> {

    void onSuccess(Response<T> response);

    void onUnauthorised();

    void onError(Throwable throwable);

    void onServerError(int errorCode, String message);

}
