package com.booktickets.api.objects;

public class Slot {

    public String getOndate() {
        return ondate;
    }

    public void setOndate(String ondate) {
        this.ondate = ondate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    private String ondate;
    private String location;
    private  String tickets;

    public Slot(){

    }

    public Slot(String ondate, String location, String tickets) {
        this.ondate = ondate;
        this.location = location;
        this.tickets = tickets;
    }
}
