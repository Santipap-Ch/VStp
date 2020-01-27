package com.example.projerct;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddEventsActivity extends AppCompatActivity {
    private EditText eventname, building, floor, room, description;
    private TextView date, timestart, timeend;
    private Button add;
    private DatabaseReference reff;
    private Event event;
    private String mEnail = getIntent().getStringExtra("mEmail");
    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        initialzeUI();

        event = new Event();

        reff = FirebaseDatabase.getInstance().getReference().child("Events");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.setEventName(eventname.getText().toString().trim());
                event.setBuilding(building.getText().toString().trim());
                event.setFloor(floor.getText().toString().trim());
                event.setRoom(room.getText().toString().trim());
                event.setDate(date.getText().toString().trim());
                event.setTimeStart(timestart.getText().toString().trim());
                event.setTimeEnd(timeend.getText().toString().trim());
                event.setDescription(description.getText().toString().trim());

                reff.push().setValue(event);

                Intent eventslist = new Intent(AddEventsActivity.this,EventsListActivity.class);
                startActivity(eventslist);
                Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year  = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(AddEventsActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + " / " + (month+1) + " / " + year);
                    }
                },day,month,year);
                dpd.show();
            }
        });

        timestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(AddEventsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timestart.setText(hourOfDay + " : " + minute);
                    }
                },hour,minute,true);
                tpd.show();
            }
        });

        timeend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(AddEventsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeend.setText(hourOfDay + " : " + minute);
                    }
                },hour,minute,true);
                tpd.show();
            }
        });
    }

    private void initialzeUI(){
        eventname = (EditText) findViewById(R.id.eventName);
        building = (EditText) findViewById(R.id.building);
        floor = (EditText) findViewById(R.id.floor);
        room = (EditText) findViewById(R.id.room);
        date = (TextView) findViewById(R.id.date);
        timestart = (TextView) findViewById(R.id.TimeStart);
        timeend = (TextView) findViewById(R.id.TimeEnd);
        description = (EditText) findViewById(R.id.description);
        add = (Button) findViewById(R.id.add);
    }
}
