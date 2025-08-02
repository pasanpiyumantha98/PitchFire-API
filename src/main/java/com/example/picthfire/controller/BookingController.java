package com.example.picthfire.controller;

import com.example.picthfire.dto.BookingDto;
import com.example.picthfire.model.Booking;
import com.example.picthfire.repo.BookingRepo;
import com.example.picthfire.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingRepo bookingRepo;

    @PostMapping("/make")
    public int makebooking(@RequestBody BookingDto bookingDto) {

        return  bookingService.makebooking(bookingDto);
    }

    @PostMapping("/delete")
    public String deleteBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.deleteBooking(bookingDto);
    }

    @GetMapping("/getbooking/{id}")
    public Booking getBooking(@PathVariable int id) {

        return bookingService.getBooking(id);
    }


    @PostMapping("/update")
    public String updateBooking(@RequestBody BookingDto bookingDto) {

        return bookingService.updateBookings(bookingDto);
    }

    @PostMapping("/getbooking")
    public List<BookingDto> getBookings(@RequestBody BookingDto bookingDto) {
        return bookingService.getBookings(bookingDto);
    }

    @PostMapping("/getrevenue")
    public 

}
