package com.example.application;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private EventAdapter eventAdapter;
    private TextView emptyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        RecyclerView eventsList = findViewById(R.id.events_list);
        emptyMessage = findViewById(R.id.events_empty_message);
        eventAdapter = new EventAdapter();

        eventsList.setLayoutManager(new LinearLayoutManager(this));
        eventsList.setAdapter(eventAdapter);

        showEvents(Collections.emptyList());
    }

    private void showEvents(List<Event> events) {
        eventAdapter.setEvents(events);
        emptyMessage.setVisibility(events.isEmpty() ? View.VISIBLE : View.GONE);
    }
}
