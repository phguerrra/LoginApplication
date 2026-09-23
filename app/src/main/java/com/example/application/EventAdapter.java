package com.example.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private final List<Event> events = new ArrayList<>();

    public void setEvents(List<Event> updatedEvents) {
        events.clear();
        events.addAll(updatedEvents);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.bind(events.get(position));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameText;
        private final TextView dateTimeText;
        private final TextView locationText;
        private final TextView descriptionText;

        EventViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.event_name);
            dateTimeText = itemView.findViewById(R.id.event_date_time);
            locationText = itemView.findViewById(R.id.event_location);
            descriptionText = itemView.findViewById(R.id.event_description);
        }

        void bind(Event event) {
            nameText.setText(event.getName());
            dateTimeText.setText(itemView.getContext().getString(
                    R.string.event_date_time, event.getDate(), event.getTime()));
            locationText.setText(event.getLocation());
            descriptionText.setText(event.getDescription());
        }
    }
}
