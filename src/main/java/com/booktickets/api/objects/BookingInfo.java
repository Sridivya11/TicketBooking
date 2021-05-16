package com.booktickets.api.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookingInfo {

    @Id
    private int id;

    public int getId() {
        return id;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String statusText;
    private String moviename;
    private String date;
    private String location;
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public BookingInfo(int id, String mobileNumber,String statusText, String moviename, String date, String location, String tickets) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.moviename = moviename;
        this.statusText = statusText;
        this.date = date;
        this.location = location;
        this.tickets = tickets;
    }



    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    private String tickets;


    public BookingInfo(){

    }
}
