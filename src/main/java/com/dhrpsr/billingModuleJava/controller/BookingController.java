package com.dhrpsr.billingModuleJava.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dhrpsr.billingModuleJava.model.Booking;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private List<Booking> bookings = new ArrayList<>();


    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        if (booking.getAmount() <= 0) {
            return ResponseEntity.badRequest().build();
        }
        // add further validation for mode etc
        bookings.add(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }


    @GetMapping
    public List<Booking> getAllBookings() {
        return bookings;
    }

}

