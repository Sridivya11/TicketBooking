package com.booktickets.api.Controller;

import com.booktickets.api.Service.MovieSlotsService;
import com.booktickets.api.objects.BookingInfo;
import com.booktickets.api.objects.MovieSlots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminMovieSlotsController {

    @Autowired
    private MovieSlotsService movieSlotsService;


    @GetMapping("/movieSlot")
    public List<MovieSlots> getAllSlots(){
        return movieSlotsService.getAllTicket();
    }

    @PostMapping("/movieSlot/add")
    public void addSlots(@RequestBody MovieSlots movieSlots){
        movieSlotsService.addSlots(movieSlots);
    }

    @GetMapping("movie/bookedInfo")
    public List<BookingInfo> getBookedInfo(){
        return movieSlotsService.getBookedInfo();
    }
}

