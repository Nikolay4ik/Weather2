package com.example.weather.Weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weather.Adapter.AdapterWeather;
import com.example.weather.Api.ApiFactory;
import com.example.weather.Api.ApiService;
import com.example.weather.Pojo.Current;
import com.example.weather.Pojo.Example;
import com.example.weather.Pojo.Location;
import com.example.weather.Pojo.Request;
import com.example.weather.R;

import java.util.ArrayList;

import io.reactivex.Observable;

public class ActivityList extends AppCompatActivity implements WeatherListView {
    private RecyclerView recyclerViewWqther;
    private AdapterWeather adapterWeather;
    private WeatherListPresenter weatherListPresenter;
    private static EditText editTextNameCity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNameCity=findViewById(R.id.EditText_nameCity);
        weatherListPresenter = new WeatherListPresenter(this);
        recyclerViewWqther = findViewById(R.id.recyclerView);
        adapterWeather = new AdapterWeather();
        Intent intent = getIntent();
        String nameCity = intent.getStringExtra("NameCity");
        weatherListPresenter.setNameCity(nameCity);
        recyclerViewWqther.setLayoutManager(new LinearLayoutManager(this));
        weatherListPresenter.loadData();
        recyclerViewWqther.setAdapter(adapterWeather);

    }

    @Override
    protected void onDestroy() {
        weatherListPresenter.disposeDisposable();
        super.onDestroy();
    }

    @Override
    public void showData(Current current, Location location, Request request) {
        adapterWeather.setRequest(request);
        adapterWeather.setCurrent(current);
        adapterWeather.setLocation(location);

    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

    }



}

