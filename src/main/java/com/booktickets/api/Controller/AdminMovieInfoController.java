package com.booktickets.api.Controller;

import com.booktickets.api.Service.MovieInfoService;
import com.booktickets.api.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminMovieInfoController {

    @Autowired
   private MovieInfoService movieInfoService;

    @RequestMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieInfoService.getAllMovies();

    }


    @RequestMapping(value="/movie/add", method= RequestMethod.POST)
    public void addMovie(@RequestBody Movie movie){

        movieInfoService.addMovies(movie);
    }


}
