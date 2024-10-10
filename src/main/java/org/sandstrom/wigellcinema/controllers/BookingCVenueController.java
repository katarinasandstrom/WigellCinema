package org.sandstrom.wigellcinema.controllers;

import org.sandstrom.wigellcinema.entities.BookingCVenue;
import org.sandstrom.wigellcinema.services.BookingCVenueService;
import org.sandstrom.wigellcinema.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")

public class BookingCVenueController {

    private BookingCVenueService bookingCVenueService;

    public BookingCVenueController(BookingCVenueService bookingCVenueService2){
        bookingCVenueService = bookingCVenueService2;
    }


    @GetMapping("/v1/bookings/customer/{customerId}")
    public List<BookingCVenue> getBookingsByCustomerId(@PathVariable int customerId) {
        return bookingCVenueService.findAllBookingsByCustomerId(customerId);
    }



}
