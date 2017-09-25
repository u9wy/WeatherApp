package com.weatherapp.weatherapi.listeners;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCallback<T> implements Callback<T> {

    private final ResponseListener<T> responseListener;

    public RetrofitCallback(ResponseListener<T> callback){
        responseListener = callback;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {

        int code = response.code();

        if(code >= 400 && code < 500) {

            if (code == 401) {
                responseListener.onUnauthorised();
            } else {
                responseListener.onServerError(code, response.message());
            }
        } else if(code >= 200 && code < 300) {
            responseListener.onSuccess(response);
        }

    }

    @Override
    public void onFailure(@NonNull Call<T> call, Throwable t) {
        responseListener.onError(t);
    }
}
