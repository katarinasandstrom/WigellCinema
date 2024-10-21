package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.entities.BookingCVenue;
import org.sandstrom.wigellcinema.entities.Customer;

import java.util.List;

public interface BookingCVenueService {

    public List<BookingCVenue> findAllBookingsByCustomerId(int customerId);

    BookingCVenue findById(int id);

    BookingCVenue save(BookingCVenue bookingCVenue);

    void deleteById(int id);



}
