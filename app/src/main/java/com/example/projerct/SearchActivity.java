package com.example.projerct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private Button btnMap;
    private Spinner spinner;
    private ArrayList<Location> locations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initialzeUI();

        locations = new Location().getLocations();

        ArrayAdapter<Location> adapter = new ArrayAdapter<Location>(this,android.R.layout.simple_spinner_item,locations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Log.i("fffff",locations.toString()); เอาไว้เช็คค่าใน Logcat

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location location = (Location) spinner.getSelectedItem();
                Intent map = new Intent(SearchActivity.this,MapsActivity.class);
                map.putExtra("location",location.getLocation());
                map.putExtra("lat",location.getLatitude());
                map.putExtra("lng",location.getLongtitude());
                map.putExtra("name",location.getName());
                Toast.makeText(getApplicationContext(),""+location.getLocation(), Toast.LENGTH_SHORT).show();
                startActivity(map);
            }
        });
    }

    private void  initialzeUI(){
        btnMap = (Button) findViewById(R.id.btnMap);
        spinner = (Spinner) findViewById(R.id.spinner);
    }
}
