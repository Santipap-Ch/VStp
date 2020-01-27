package com.example.projerct;

public class Event {

    private String EventName;
    private String Building;
    private String Floor;
    private String Room;
    private String Date;
    private String TimeStart;
    private String Description;
    private String TimeEnd;

    public Event() {
    }

    public Event(String eventName, String building, String floor, String room, String date, String timeStart, String description, String timeEnd) {
        EventName = eventName;
        Building = building;
        Floor = floor;
        Room = room;
        Date = date;
        TimeStart = timeStart;
        Description = description;
        TimeEnd = timeEnd;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getBuilding() {
        return Building;
    }

    public void setBuilding(String building) {
        Building = building;
    }

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String room) {
        Room = room;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(String timeStart) {
        TimeStart = timeStart;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTimeEnd() {
        return TimeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        TimeEnd = timeEnd;
    }
}
