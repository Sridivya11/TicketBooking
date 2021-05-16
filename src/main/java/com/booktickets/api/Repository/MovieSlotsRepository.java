package com.booktickets.api.Repository;

import com.booktickets.api.objects.BookingInfo;
import com.booktickets.api.objects.BookingRequest;
import com.booktickets.api.objects.MovieSlots;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MovieSlotsRepository extends CrudRepository<MovieSlots,String> {

    @Query("SELECT date,location,numberOfTickets FROM MovieSlots m WHERE m.movieName = :name")
    List<Object[]> findByMovieName(@Param("name") String name);

    @Query("SELECT m FROM MovieSlots m WHERE  m.movieName = :#{#bR.movie} AND m.location = :#{#bR.locationName} AND m.date = :#{#bR.date}")
    MovieSlots findByBookingRequest(@Param("bR") BookingRequest bR);

    @Modifying
    @Query("UPDATE MovieSlots m SET m.numberOfTickets = :tickets WHERE m.id = :id")
    void updateNumberOfTickets(@Param("id") int id,@Param("tickets") String tickets);



}