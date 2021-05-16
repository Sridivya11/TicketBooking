package com.booktickets.api.Controller;

import com.booktickets.api.Service.MovieInfoService;
import com.booktickets.api.Service.MovieSlotsService;
import com.booktickets.api.objects.BookingInfo;
import com.booktickets.api.objects.BookingRequest;
import com.booktickets.api.objects.Movie;
import com.booktickets.api.objects.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private MovieSlotsService movieSlotsService;

    @RequestMapping(value="movie/{name}", method= RequestMethod.GET)
    public List<Movie> getmovieByname(@PathVariable String name){
        return movieInfoService.getMoviesByName(name);
    }

    @RequestMapping(value="movie/location/{name}", method= RequestMethod.GET)
    public List<Movie> getmovieBylocation(@PathVariable String name){
        return movieInfoService.getMoviesbyLocation(name);
    }


    @RequestMapping(value="/movie/rating/{rating}",method = RequestMethod.GET)
    public List<Movie> getmovieByrating(@PathVariable String rating){
        return movieInfoService.getMoviesbyRating(rating);
    }

    @RequestMapping(value="/movieSlot/{name}" ,method = RequestMethod.GET)
    public List<Slot> getMovieSlotsByName(@PathVariable String name){
        return movieSlotsService.getSlotsByName(name);
    }

    @PostMapping("/movieSlot/book")
    public BookingInfo getTicketsInfo(@RequestBody BookingRequest br){

        return movieSlotsService.bookTheTicket(br);
    }

  @GetMapping("/movie/bookedInfo/{number}")
    public List<BookingInfo> bookedInfoByMobileNumber(@PathVariable String number){
      return movieSlotsService.getBookedInfoByMobileNumber(number);

  }

  @GetMapping("/movie/genre/{value}")
    public List<Movie> getMovieBygenre(@PathVariable String value){
        return movieInfoService.getMoviesByGenre(value);
  }

  @PutMapping("/movie/cancel/{id}")
    public String cancelMovieById(@PathVariable int id){
        return  movieSlotsService.getByIdToCancel(id);
  }

}
