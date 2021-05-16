package com.booktickets.api.Service;

import com.booktickets.api.Repository.MovieInfoRepository;
import com.booktickets.api.objects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieInfoService {

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    public List<Movie> getAllMovies(){
        List<Movie>  movieList = new ArrayList<>();
        movieInfoRepository.findAll().forEach(movieList::add);

        return movieList;
    }

    public List<Movie> getMoviesByName(String name){
        List<Movie>  movieList = new ArrayList<>();
        movieInfoRepository.findByMovieNameIgnoreCase(name).forEach(movieList::add);
        return movieList;
    }

    public void addMovies(Movie movie){

        movieInfoRepository.save(movie);
    }

    public List<Movie> getMoviesbyRating(String value){
        List<Movie> moveList = new ArrayList<>();
        movieInfoRepository.findByRatingGreaterThanEqual(value).
                forEach(moveList::add);
        return moveList;
    }

    public List<Movie> getMoviesbyLocation(String value){
        List<Movie> moveList = new ArrayList<>();
        movieInfoRepository.findByLocations(value).
                forEach(moveList::add);

        return moveList;
    }

    public List<Movie> getMoviesByGenre(String valu){
        List<Movie> movielist = new ArrayList<>();
        movieInfoRepository.findByGenreIgnoreCase(valu).forEach(movielist:: add);
        return movielist;
    }



}
