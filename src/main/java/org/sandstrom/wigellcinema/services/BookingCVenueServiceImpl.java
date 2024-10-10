package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.controllers.BookingCVenueController;
import org.sandstrom.wigellcinema.dao.BookingCVenueRepository;
import org.sandstrom.wigellcinema.dao.CustomerRepository;
import org.sandstrom.wigellcinema.entities.BookingCVenue;
import org.sandstrom.wigellcinema.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingCVenueServiceImpl implements BookingCVenueService {


    @Autowired
    private BookingCVenueRepository bookingCVenueRepository;

    @Override
    public List<BookingCVenue> findAllBookingsByCustomerId(int customerId) {
        return bookingCVenueRepository.findByCustomerId(customerId);
    }

    @Override
    public BookingCVenue save(BookingCVenue bookingCVenue){
        return bookingCVenueRepository.save(bookingCVenue);
    }

    @Override
    public void deleteById(int id){
        bookingCVenueRepository.deleteById(id);
    }

}
