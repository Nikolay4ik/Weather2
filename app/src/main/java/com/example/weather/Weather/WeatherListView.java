package com.example.weather.Weather;

import com.example.weather.Pojo.Current;
import com.example.weather.Pojo.Example;
import com.example.weather.Pojo.Location;
import com.example.weather.Pojo.Request;

public interface WeatherListView {
    void showData(Current current, Location location, Request request);
    void showError();
}
