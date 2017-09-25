package com.weatherapp.module.weatherforecast.view.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weatherapp.R;
import com.weatherapp.datamodel.internal.DailyForecast;
import com.weatherapp.datamodel.internal.Header;

import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int VIEW_TYPE_HEADER = 0;
    private static int VIEW_TYPE_ITEM = 1;

    private List<Object> itemList;

    public MainAdapter(List<Object> itemList) {
        this.itemList = itemList;
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        RecyclerView itemRecyclerView;
        NestedAdapter nestedAdapter;
        LinearLayoutManager layoutManager;

        ItemViewHolder(View view) {
            super(view);
            itemRecyclerView = view.findViewById(R.id.recyclerView_daily_forecast);
            layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        }

    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView textViewHeader;

        HeaderViewHolder(View view) {
            super(view);
            textViewHeader = view.findViewById(R.id.textView_header);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == VIEW_TYPE_HEADER) {
            HeaderViewHolder viewHolder = (HeaderViewHolder) holder;
            Header header = (Header) itemList.get(position);

            viewHolder.textViewHeader.setText(header.getHeaderName());
        } else {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            DailyForecast dailyForecasts = (DailyForecast) itemList.get(position);

            if (viewHolder.nestedAdapter != null) {
                viewHolder.nestedAdapter.setItems(dailyForecasts.getDailyForecastList());
            } else {
                viewHolder.nestedAdapter = new NestedAdapter(dailyForecasts.getDailyForecastList());
                viewHolder.itemRecyclerView.setLayoutManager(viewHolder.layoutManager);
                viewHolder.itemRecyclerView.setAdapter(viewHolder.nestedAdapter);
            }
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_HEADER) {
            return new HeaderViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.main_recyclerview_header_row, parent, false));
        } else if (viewType == VIEW_TYPE_ITEM) {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.main_recyclerview_row, parent, false));
        }

        throw new RuntimeException("Adapter " + viewType + "not found");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position) instanceof Header ?
                VIEW_TYPE_HEADER : VIEW_TYPE_ITEM;
    }
}
