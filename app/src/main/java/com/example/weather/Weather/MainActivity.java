package com.example.weather.Weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.weather.Api.ApiFactory;
import com.example.weather.R;

public class MainActivity extends AppCompatActivity {
private EditText editTextNameCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_list);
        editTextNameCity=findViewById(R.id.EditText_nameCity);



    }

    public void onClickSave(View view) {
        String NameCity=editTextNameCity.getText().toString().trim();
        Intent intent=new Intent(this,ActivityList.class);
        intent.putExtra("NameCity",NameCity);
        startActivity(intent);
}
    }

