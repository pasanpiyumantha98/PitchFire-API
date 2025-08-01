package com.example.picthfire.repo;

import com.example.picthfire.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;


public interface BookingRepo extends JpaRepository<Booking, Integer> {

    @Query(value = "select max(id) from booking", nativeQuery = true)
    Integer getMaxId();

    @Query(value="select COUNT(*) from booking where propid=?1 and date=?2 and (stime<?4 and etime>?3)",nativeQuery = true)
    int checkbooking(int propid, LocalDate date, LocalTime stime, LocalTime etime);

    @Query(value="select * from booking where id=?1", nativeQuery = true)
    Booking getBooking(int id);
}
