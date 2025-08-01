package com.example.picthfire.controller;

import com.example.picthfire.dto.BookingDto;
import com.example.picthfire.repo.BookingRepo;
import com.example.picthfire.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/make")
    public int makebooking(@RequestBody BookingDto bookingDto) {

        return  bookingService.makebooking(bookingDto);
    }
}
