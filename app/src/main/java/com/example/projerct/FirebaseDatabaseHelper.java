package com.example.projerct;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceEvents, getmReferenceEventsChildren;
    private List<Event> events = new ArrayList<>();
    private List<Event> events1 = new ArrayList<>();
    private List<String> keys = new ArrayList<>();
    private List<String> keys1 = new ArrayList<>();


    public interface DataStatus{
        void DataIsLoaded(List<Event> events, List<String> keys);
        void DataIsInserted(List<Event> events, List<String> keys);
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceEvents = mDatabase.getReference();
    }

    public void readEvents(final DataStatus dataStatus){
        mReferenceEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events1.clear();
//                final List<String> keys1 = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    getmReferenceEventsChildren = mDatabase.getReference(keyNode.getKey());
                    getmReferenceEventsChildren.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot keyNode2 : dataSnapshot.getChildren()){
                                keys1.add(keyNode2.getKey());
                                Event event = keyNode2.getValue(Event.class);
                                events1.add(event);

                            }
                            dataStatus.DataIsInserted(events1, keys1);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public FirebaseDatabaseHelper(String mEmail) {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceEvents = mDatabase.getReference(mEmail);
    }

    public void readEvent(final DataStatus dataStatus){
        mReferenceEvents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                events.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Event event = keyNode.getValue(Event.class);
                    events.add(event);
                }
                Log.i("test5555555",""+events.size());
                dataStatus.DataIsLoaded(events, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateEvent(String key, Event event, final DataStatus dataStatus){
        mReferenceEvents.child(key).setValue(event).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void deletEvent(String key,final DataStatus dataStatus){
        mReferenceEvents.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
