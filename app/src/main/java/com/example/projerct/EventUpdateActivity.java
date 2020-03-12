package com.example.projerct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class EventUpdateActivity extends AppCompatActivity {

    private EditText mEventname, mBuilding, mFloor, mRoom, mDescription;
    private TextView mDate, mTimestart, mTimeend;
    private Button mDelete_btn,mUpdate_btn;

    private String key;
    private String eventname, building, floor, room, description,date, timestart, timeend;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_update);

        key = getIntent().getStringExtra("key");
        eventname = getIntent().getStringExtra("eventname");
        building = getIntent().getStringExtra("building");
        floor = getIntent().getStringExtra("floor");
        room = getIntent().getStringExtra("room");
        description = getIntent().getStringExtra("description");
        date = getIntent().getStringExtra("date");
        timestart = getIntent().getStringExtra("timestart");
        timeend = getIntent().getStringExtra("timeend");
        email = getIntent().getStringExtra("email");

        mEventname = (EditText) findViewById(R.id.eventName);
        mEventname.setText(eventname);
        mBuilding = (EditText) findViewById(R.id.building);
        mBuilding.setText(building);
        mFloor = (EditText) findViewById(R.id.floor);
        mFloor.setText(floor);
        mRoom = (EditText) findViewById(R.id.room);
        mRoom.setText(room);
        mDescription = (EditText) findViewById(R.id.description);
        mDescription.setText(description);
        mDate = (TextView) findViewById(R.id.date);
        mDate.setText(date);
        mTimestart = (TextView) findViewById(R.id.TimeStart);
        mTimestart.setText(timestart);
        mTimeend = (TextView) findViewById(R.id.TimeEnd);
        mTimeend.setText(timeend);

        mDelete_btn = (Button) findViewById(R.id.delete_btn);
        mUpdate_btn = (Button) findViewById(R.id.update_btn);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event = new Event();
                event.setEventName(mEventname.getText().toString());
                event.setBuilding(mBuilding.getText().toString());
                event.setFloor(mFloor.getText().toString());
                event.setRoom(mRoom.getText().toString());
                event.setDescription(mDescription.getText().toString());
                event.setDate(mDate.getText().toString());
                event.setTimeStart(mTimestart.getText().toString());
                event.setTimeEnd(mTimeend.getText().toString());
                event.setEmail(email);

                new  FirebaseDatabaseHelper(email).updateEvent(key, event, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Event> events, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted(List<Event> events, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(EventUpdateActivity.this,"Event record has been"+" updated successfully",Toast.LENGTH_LONG).show();
                        finish(); return;
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
        mDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper(email).deletEvent(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Event> events, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted(List<Event> events, List<String> keys) {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(EventUpdateActivity.this,"Event record has been "+"deleted successfully",Toast.LENGTH_LONG).show();
                        finish(); return;
                    }
                });
            }
        });
    }
}
