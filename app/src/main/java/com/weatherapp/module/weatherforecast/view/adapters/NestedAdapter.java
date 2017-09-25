package com.weatherapp.module.weatherforecast.view.adapters;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weatherapp.R;
import com.weatherapp.util.DateTimeUtil;
import com.weatherapp.datamodel.external.Forecast;
import com.weatherapp.weatherapi.BaseUrls;

import java.util.List;


class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.ViewHolder> {

    private static final String PNG_FORMAT = ".png";
    private List<Forecast> itemList;

    NestedAdapter(List<Forecast> itemList) {
        this.itemList = itemList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        TextView textViewTime;
        TextView textViewWeatherDescription;
        ImageView imageViewIcon;
        TextView textViewTempreture;
        TextView textViewWindDirection;
        TextView textViewHumidityValue;
        TextView textViewPressureDescription;
        TextView textViewWindValue;

        ViewHolder(View view) {
            super(view);
            imageViewIcon = view.findViewById(R.id.imageView_icon);
            textViewTime = view.findViewById(R.id.textView_time);
            textViewWeatherDescription = view.findViewById(R.id.textView_weather_description);
            textViewTempreture = view.findViewById(R.id.textView_temp);
            textViewWindDirection = view.findViewById(R.id.textView_wind_direction);
            textViewHumidityValue = view.findViewById(R.id.textView_humidity_value);
            textViewPressureDescription = view.findViewById(R.id.textView_pressure_value);
            textViewWindValue = view.findViewById(R.id.textView_wind_value);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.nested_recyclerview_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Forecast forecast = itemList.get(position);

        Resources resource = holder.imageViewIcon.getContext().getResources();

        holder.textViewTime.setText(DateTimeUtil.getTime(forecast.getDateTime()));
        holder.textViewWeatherDescription.setText(forecast.getWeather().getDescription());
        holder.textViewTempreture.setText(resource.getString(R.string.temp_celcius, String.valueOf(forecast.getMain().getTemp())));
        holder.textViewWindDirection.setText(resource.getString(R.string.wind_direction, String.valueOf((int)forecast.getWind().getDegrees())));
        holder.textViewHumidityValue.setText(resource.getString(R.string.humidity, String.valueOf(forecast.getMain().getHumidityPercentage())));
        holder.textViewPressureDescription.setText(resource.getString(R.string.pressure, String.valueOf(forecast.getMain().getPressure())));
        holder.textViewWindValue.setText(resource.getString(R.string.wind_speed, String.valueOf(forecast.getWind().getSpeed())));


        Glide.with(holder.imageViewIcon.getContext())
                .load(BaseUrls.IMAGE_ICON_URL + forecast.getWeather().getIcon() + PNG_FORMAT)
                .into(holder.imageViewIcon);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    void setItems(List<Forecast> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }
}
