package com.example.projerct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private EventsAdapter mEventsAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Event> events, List<String> keys){
        mContext = context;
        mEventsAdapter = new EventsAdapter(events, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mEventsAdapter);
    }

    class  EventItempView extends RecyclerView.ViewHolder{
        private TextView mDate;
        private TextView mNameEvent;
        private TextView mLocation;

        private String key;

        public EventItempView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.event_list_item,parent,false));
            mDate = (TextView) itemView.findViewById(R.id.date_txtView);
            mNameEvent = (TextView) itemView.findViewById(R.id.nameEvent_txtView);
            mLocation = (TextView) itemView.findViewById(R.id.location_txtView);

        }
        public void  bind(Event event,String key){
            mDate.setText(event.getDate());
            mNameEvent.setText(event.getEventName());
            mLocation.setText(event.getBuilding()+event.getFloor()+event.getRoom());
            this.key = key;
        }
    }
    class  EventsAdapter extends RecyclerView.Adapter<EventItempView>{
        private List<Event> mEventList;
        private List<String> mKeys;

        public EventsAdapter(List<Event> mEventList, List<String> mKeys) {
            this.mEventList = mEventList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public EventItempView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EventItempView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull EventItempView holder, int position) {
            holder.bind(mEventList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mEventList.size();
        }
    }
}
