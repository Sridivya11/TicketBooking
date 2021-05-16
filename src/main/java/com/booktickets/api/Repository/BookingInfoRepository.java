package com.booktickets.api.Repository;

import com.booktickets.api.objects.BookingInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingInfoRepository extends CrudRepository<BookingInfo,String> {

Iterable<BookingInfo> findByMobileNumber(String mobileNumber);

@Modifying
@Query("UPDATE BookingInfo b SET b.statusText = :status WHERE b.id = :bookingId")
int updateByStatusText(@Param("status") String status,@Param("bookingId") int bookingId);
}
