package com.example.picthfire.services;

import com.example.picthfire.dto.BookingDto;
import com.example.picthfire.model.Booking;
import com.example.picthfire.repo.BookingRepo;
import com.example.picthfire.repo.PropertyRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepo bookingRepo;

    // Making a new booking
    public int makebooking(BookingDto bookingDto) {

        //checking exsiting bookings
        int booking = bookingRepo.checkbooking(bookingDto.getPropid(),bookingDto.getDate(),bookingDto.getStime(),bookingDto.getEtime());

        if(booking == 0) {

            Integer maxid = bookingRepo.getMaxId();

            if (maxid == null) {
                bookingDto.setId(1001);
            } else {
                bookingDto.setId(maxid + 4);
            }

            bookingRepo.save(modelMapper.map(bookingDto, Booking.class));

            return bookingDto.getId();

        } else
        {
            return -99;
        }

    }
}
