package com.example.application;

public class Event {
    private final String name;
    private final String date;
    private final String time;
    private final String location;
    private final String description;

    public Event(String name, String date, String time, String location, String description) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }
}
