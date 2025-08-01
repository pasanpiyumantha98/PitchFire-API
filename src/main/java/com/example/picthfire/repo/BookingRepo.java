package com.example.picthfire.repo;

import com.example.picthfire.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface BookingRepo extends JpaRepository<Booking, Integer> {

    @Query(value = "select max(id) from booking", nativeQuery = true)
    Integer getMaxId();
}
