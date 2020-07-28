package com.example.weather.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weather.Pojo.Current;
import com.example.weather.Pojo.Example;
import com.example.weather.Pojo.Location;
import com.example.weather.Pojo.Request;

import com.example.weather.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdapterWeather extends RecyclerView.Adapter<AdapterWeather.WeatherViewHolder> {
    // private List<Weather> weathers;
    //private List<Current> currents;
    // private List<Example> examples;
    // private List<Location>locations;
    //  private List<Request> requests;
    private Current current;
    private Location location;
    private Request request;
    private Example example;

    public AdapterWeather() {
        current = new Current();
        location = new Location();
        request = new Request();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        notifyDataSetChanged();
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
        notifyDataSetChanged();
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inform_item, viewGroup, false);

        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {

        weatherViewHolder.nameCity.setText(location.getName());
        weatherViewHolder.temperature.setText(Float.toString(current.getTemperature()));
        weatherViewHolder.speed.setText(Float.toString(current.getWindSpeed()));
        weatherViewHolder.pressing.setText(Float.toString(current.getPressure()));
        weatherViewHolder.region.setText(location.getRegion());
        weatherViewHolder.cantry.setText(location.getCountry());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder {
        private TextView nameCity;
        private TextView temperature;
        private TextView number_day;
        private TextView speed;
        private TextView pressing;
        private TextView region;
        private TextView cantry;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCity = itemView.findViewById(R.id.textView_nameCity);
            temperature = itemView.findViewById(R.id.textView_temperature);
            speed = itemView.findViewById(R.id.textView_speed);
            pressing = itemView.findViewById(R.id.textView_pressing);
            region = itemView.findViewById(R.id.textView_region);
            cantry = itemView.findViewById(R.id.textView_country);


        }
    }
}
