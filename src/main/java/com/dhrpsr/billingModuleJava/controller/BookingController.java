package com.dhrpsr.billingModuleJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dhrpsr.billingModuleJava.model.Booking;
import com.dhrpsr.billingModuleJava.service.BookingService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private List<Booking> bookings = new ArrayList<>();

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        try {
            Booking created = bookingService.createBooking(booking);
            bookings.add(created);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(Collections.singletonMap("error", ex.getMessage()));
        }
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookings;
    }
}