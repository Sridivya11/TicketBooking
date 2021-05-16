package com.booktickets.api.Service;

import com.booktickets.api.Exception.NotFoundException;
import com.booktickets.api.Repository.BookingInfoRepository;
import com.booktickets.api.Repository.MovieSlotsRepository;
import com.booktickets.api.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieSlotsService {

    @Autowired
    private MovieSlotsRepository movieSlotsRepository;

    @Autowired
    private BookingInfoRepository bookingInfoRepository;

    public void addSlots(MovieSlots movieSlots){
        movieSlotsRepository.save(movieSlots);
    }

    public List<MovieSlots> getAllTicket(){
        List<MovieSlots> movieSlots = new ArrayList<>();
        movieSlotsRepository.findAll().forEach(movieSlots::add);
        return  movieSlots ;
    }

    public List<Slot> getSlotsByName(String name){
        List<Slot> movieSlots = new ArrayList<>();
        List<Object[]> slots = movieSlotsRepository.findByMovieName(name);
        slots.forEach((temp) -> {
            movieSlots.add(new Slot(temp[0].toString(),temp[1].toString(),temp[2].toString()));
        });
        return movieSlots;

    }

    @Transactional
    public BookingInfo bookTheTicket(BookingRequest bookingRequest){

        BookingInfo bookingInfo ;

        MovieSlots movieSlots = movieSlotsRepository.findByBookingRequest(bookingRequest);
        int Id = movieSlots.getId();

        String tickets = movieSlots.getNumberOfTickets();
        int actualTickets = Integer.parseInt(tickets);

        String temp1 = bookingRequest.getTicketsTobeBook();
        int reqTicket = Integer.parseInt(temp1);

        int diff = actualTickets-reqTicket;
        String presentTickets = String.valueOf(diff);

        if(diff> 0){
            int min = 10000;
            int max =  99999;
            int id = (int)(Math.random()*(max-min+1)+min);
            bookingInfo = new BookingInfo(id,
                    bookingRequest.getMobileNumber(),
                    "Great, Your ticket booking is successful. Please find the details",
                    bookingRequest.getMovie(),
                    bookingRequest.getDate(),
                    bookingRequest.getLocationName()
                    ,bookingRequest.getTicketsTobeBook());

            addBookInfo(bookingInfo);
            movieSlotsRepository.updateNumberOfTickets(Id,presentTickets);
        }
        else{
            bookingInfo = new BookingInfo(0,"","Your ticket booking is Unsuccessful. Please Try Again","","",
                    "","");
        }
        return bookingInfo;
    }

    public void addBookInfo(BookingInfo bookingInfo){
        bookingInfoRepository.save(bookingInfo);
    }

    public  List<BookingInfo> getBookedInfo(){
        List<BookingInfo> booking= new ArrayList<>();
        bookingInfoRepository.findAll().forEach(booking::add);
        return booking;
    }

    public List<BookingInfo> getBookedInfoByMobileNumber(String phn){
        List<BookingInfo> bookingInfos = new ArrayList<>();
        bookingInfoRepository.findByMobileNumber(phn).forEach(bookingInfos::add);
        return bookingInfos;
    }

    @Transactional
    public String getByIdToCancel(int Id){

        String status = "Cancel";

        int val = bookingInfoRepository.updateByStatusText(status,Id);
       System.out.println("***"+val);
        if(val == 1){
            return "Cancel Successfully";
        }else{

            throw new NotFoundException();

        }



    }

}
