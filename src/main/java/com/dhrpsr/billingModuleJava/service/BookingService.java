package com.dhrpsr.billingModuleJava.service;

import org.springframework.stereotype.Service;
import com.dhrpsr.billingModuleJava.model.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BookingService: business logic for bookings.
 * - validate input (mode, date, amount)
 * - store bookings in-memory (for now)
 */
@Service
public class BookingService {

    // in-memory store for demo purposes
    private final List<Booking> bookings = new ArrayList<>();

    /**
     * Create a booking after validating business rules.
     *
     * @param booking input booking object (expects date as "yyyy-MM-dd")
     * @return the saved booking
     * @throws IllegalArgumentException if validation fails
     */
    private long nextLR = 100000;
    public Booking createBooking(Booking booking) {
        // null checks (defensive)
        if (booking == null) {
            throw new IllegalArgumentException("booking cannot be null");
        }
         if (booking.getLR() == null || booking.getLR().isEmpty()) {
        booking.setLR(String.valueOf(nextLR++));
        }
        // Validate mode
        List<String> allowedModes = Arrays.asList("By Road", "By Air", "PTL", "FTL");
        if (booking.getMode() == null || !allowedModes.contains(booking.getMode())) {
            throw new IllegalArgumentException("mode must be one of By Road, By Air, PTL, FTL");
        }

        // Validate date
        if (booking.getDate() == null) {
            throw new IllegalArgumentException("date is required in yyyy-MM-dd format");
        }
        LocalDate bookingDate;
        try {
            bookingDate = LocalDate.parse(booking.getDate()); // expects ISO yyyy-MM-dd
        } catch (Exception ex) {
            throw new IllegalArgumentException("date must be in yyyy-MM-dd format");
        }
        if (bookingDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("booking date cannot be in the past");
        }

        // Validate amount
        if (booking.getAmount() <= 0) {
            throw new IllegalArgumentException("amount must be greater than 0");
        }

        // All good -> save (in-memory) and return
        bookings.add(booking);
        return booking;
    }

    /**
     * Return all bookings (in-memory).
     */
    public List<Booking> getAllBookings() {
        return bookings;
    }
}
