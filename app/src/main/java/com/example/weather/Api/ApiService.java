package com.example.weather.Api;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;


import com.example.weather.Adapter.AdapterWeather;
import com.example.weather.Pojo.Example;
import com.example.weather.R;
import com.example.weather.Weather.ActivityList;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {

    String uri = "current?access_key=3a06933de820c255db6af26bfe234506&query=Екатеринбург";

    @GET(uri)
    Observable<Example> getWeather(@Query("query") String name, @Query("access_key") String key);

}
