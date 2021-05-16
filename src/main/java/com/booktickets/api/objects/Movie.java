package com.booktickets.api.objects;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    private String movieName;
    private String genre;
    private String rating;

    @ElementCollection
    private Set<String> locations = new HashSet<String>();

    public Set<String> getLocations() {
        return locations;
    }

    public void setLocations(Set<String> locations) {
        this.locations = locations;
    }


    private String playDatefrom;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String playDateTo;
    private String description;

    public Movie(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPlayDatefrom() {
        return playDatefrom;
    }

    public void setPlayDatefrom(String playDatefrom) {
        this.playDatefrom = playDatefrom;
    }

    public String getPlayDateTo() {
        return playDateTo;
    }

    public void setPlayDateTo(String playDateTo) {
        this.playDateTo = playDateTo;
    }





}
