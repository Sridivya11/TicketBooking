package com.booktickets.api.objects;

public class BookingRequest {

    private String movie;
    private String locationName;
    private String date;
    private String ticketsTobeBook;
    private String mobileNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTicketsTobeBook() {
        return ticketsTobeBook;
    }

    public void setTicketsTobeBook(String ticketsTobeBook) {
        this.ticketsTobeBook = ticketsTobeBook;
    }

    public BookingRequest(){}

}
