package org.sandstrom.wigellcinema.dao;

import org.sandstrom.wigellcinema.entities.BookingCVenue;
import org.sandstrom.wigellcinema.services.BookingCVenueService;
import org.sandstrom.wigellcinema.services.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingCVenueRepository extends JpaRepository<BookingCVenue, Integer> {

        List<BookingCVenue> findByCustomerId(int customerId);
    }


