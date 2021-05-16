package com.booktickets.api.Repository;

import com.booktickets.api.objects.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface MovieInfoRepository extends CrudRepository<Movie,String>
{
    Iterable<Movie> findByMovieNameIgnoreCase(String name);

    @Query(value ="SELECT m FROM Movie m WHERE :name MEMBER OF m.locations")
    Iterable<Movie> findByLocations(@Param("name") String name);

    Iterable<Movie> findByRatingGreaterThanEqual(String value);

    Iterable<Movie> findByGenreIgnoreCase(String value);
}