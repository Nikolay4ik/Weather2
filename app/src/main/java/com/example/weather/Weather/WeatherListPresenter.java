package com.example.weather.Weather;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weather.Api.ApiFactory;
import com.example.weather.Api.ApiService;
import com.example.weather.Pojo.Current;
import com.example.weather.Pojo.Example;

import java.net.URISyntaxException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WeatherListPresenter {
    private CompositeDisposable compositeDisposable;
    private WeatherListView weatherListView;
    private EditText editTextNameCity;
    private String nameCity;
    private String key;

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public WeatherListPresenter(WeatherListView weatherListView) {
        this.weatherListView = weatherListView;
        //nameCity = "Новосибирск";
        key = "3a06933de820c255db6af26bfe234506";

    }


    public void loadData() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();

        compositeDisposable = new CompositeDisposable();
        Disposable disposable = apiService.getWeather(nameCity, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Example>() {
                               @Override
                               public void accept(Example weatherResponce) throws Exception {
                                   weatherListView.showData(weatherResponce.getCurrent(), weatherResponce.getLocation(), weatherResponce.getRequest());


                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   weatherListView.showError();
                               }
                           }

                );
        compositeDisposable.add(disposable);
    }

    public void disposeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
