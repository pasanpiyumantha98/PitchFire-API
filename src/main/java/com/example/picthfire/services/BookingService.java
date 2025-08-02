package com.example.picthfire.services;

import com.example.picthfire.dto.BookingDto;
import com.example.picthfire.model.Booking;
import com.example.picthfire.repo.BookingRepo;
import com.example.picthfire.repo.PropertyRepo;
import com.example.picthfire.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class BookingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private UserRepo userRepo;

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

    public String deleteBooking(BookingDto bookingDto)
    {
        Booking booking = bookingRepo.getBooking(bookingDto.getId());

        if(booking == null) {
            return "notfound";
        } else
        {
            bookingRepo.delete(booking);
            return "deleted";
        }


    }

    public Booking getBooking(int id) {
        return bookingRepo.getBooking(id);
    }

    //update date and time of exsiting bookings
    public String updateBookings(BookingDto bookingDto) {

        Booking booking = bookingRepo.getBooking(bookingDto.getId());

        if(booking == null) {
            return "notfound";

        } else
        {
            //checking exsiting bookings

            int propid = bookingRepo.getpropid(bookingDto.getId());
            int bookings = bookingRepo.checkbooking(propid,bookingDto.getDate(),bookingDto.getStime(),bookingDto.getEtime());

            if(bookings > 0) {
                return "cannotChange";
            } else
            {
                LocalDate ndate = bookingDto.getDate();
                LocalTime   stime = bookingDto.getStime();
                LocalTime etime = bookingDto.getEtime();
                bookingRepo.updateBooking(ndate,stime,etime,bookingDto.getId());
                return "updated";
            }
        }
    }

    //Taking list of bookings
    public  List<BookingDto> getBookings(BookingDto bookingDto)
    {
        List<Booking> bookings = bookingRepo.getBookings(bookingDto.getDate());
        return modelMapper.map(bookings, new TypeToken<List<BookingDto>>() {}.getType());
    }

    //Calculating Revenue
    public double sumPrice(BookingDto bookingDto) {

        return bookingRepo.sumPrice(bookingDto.getDate(), bookingDto.getPropid());
    }


}
