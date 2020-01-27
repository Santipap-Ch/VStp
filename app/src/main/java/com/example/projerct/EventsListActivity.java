package com.example.projerct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class EventsListActivity extends AppCompatActivity {
    private Button addBtn, deleteBtn;
    private RecyclerView mRecyclerView;
    private String mEmail = getIntent().getStringExtra("mEmail");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);

        initialzeUI();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclreview_events);
        new FirebaseDatabaseHelper().readEvents(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Event> events, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, EventsListActivity.this,events,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(EventsListActivity.this,AddEventsActivity.class);
                add.putExtra("mEmail",mEmail);
                startActivity(add);
            }
        });
    }

    private void initialzeUI(){
        addBtn = (Button) findViewById(R.id.add);
        deleteBtn = (Button) findViewById(R.id.delete);
    }
}
