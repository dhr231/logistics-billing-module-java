package com.dhrpsr.billingModuleJava.service;

import org.springframework.stereotype.Service;
import com.dhrpsr.billingModuleJava.model.Booking;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class BookingService {

    public Booking createBooking(Booking booking) {
        // Validate mode
        List<String> allowedModes = Arrays.asList("By Road", "By Air", "PTL", "FTL");
        if (!allowedModes.contains(booking.getMode())) {
            throw new IllegalArgumentException("mode must be one of By Road, By Air, PTL, FTL");
        }

        // Validate date (not before today)
        LocalDate bookingDate = LocalDate.parse(booking.getDate());
        if (bookingDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("booking date cannot be in the past");
        }

        // Validate amount (greater than 0)
        if (booking.getAmount() <= 0) {
            throw new IllegalArgumentException("amount must be greater than 0");
        }

        // Optionally: you could set LR or timestamp, etc.
        // For now: just return the booking (in-memory)
        return booking;
    }
}