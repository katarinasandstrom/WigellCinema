package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.entities.Venue;

import java.util.List;

public interface VenueService {

    List<Venue> findAll();

    Venue findById(int id);

    Venue save(Venue venue);

    void deleteById(int id);
}
