package com.dhrpsr.billingModuleJava.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @GetMapping("/hello")
    public String hello() {
        return "Booking service is up and running!";
    }
}