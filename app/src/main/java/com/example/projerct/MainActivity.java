package com.example.projerct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout eventsBtn, searchBtn, adminBtn, contactBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();

        eventsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent events = new Intent(MainActivity.this,EventsActivity.class);
                startActivity(events);
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(search);
            }
        });

        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent admin = new Intent(MainActivity.this,AdminActivity.class);
                startActivity(admin);
            }
        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent(MainActivity.this,ContactActivity.class);
                startActivity(contact);
            }
        });

    }

    private void initializeUI(){
        eventsBtn = findViewById(R.id.events);
        searchBtn = findViewById(R.id.search);
        adminBtn = findViewById(R.id.admin);
        contactBtn = findViewById(R.id.contact);
    }
}