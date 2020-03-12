package com.example.projerct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private Button myEventBtn;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        initialzeUI();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclreview_events);
        new FirebaseDatabaseHelper().readEvents(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Event> events, List<String> keys) {

            }

            @Override
            public void DataIsInserted(List<Event> events, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView, EventsActivity.this,events,keys);

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

//        myEventBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent add = new Intent(EventsActivity.this,AddEventsActivity.class);
//                //Toast.makeText(getApplicationContext(), "Sign in successful"+mEmail, Toast.LENGTH_SHORT).show();
////                add.putExtra(Intent.EXTRA_TEXT,mEmail);
//                startActivity(add);
//            }
//        });
    }

    private void initialzeUI(){
        myEventBtn = (Button) findViewById(R.id.myEvents);
    }

}
