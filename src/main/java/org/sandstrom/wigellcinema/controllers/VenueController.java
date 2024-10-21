package org.sandstrom.wigellcinema.controllers;

import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.entities.Venue;
import org.sandstrom.wigellcinema.services.CustomerService;
import org.sandstrom.wigellcinema.services.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VenueController {


    private VenueService venueService;

    public VenueController(VenueService venueSer){
        venueService = venueSer;
    }
    @GetMapping("/v1/rooms")
    public List<Venue> findAll(){
        return venueService.findAll();
    }

    @GetMapping("/v1/rooms/{id}")
    public Venue getVenue (@PathVariable int id) {
        Venue venue = venueService.findById(id);
        if (venue == null) {
            throw new RuntimeException("Lokal med id " + id + " hittades inte.");
        }
        return venue;
    }
    @PutMapping("/v1/rooms/{id}")
    public Venue venue(@PathVariable int id, @RequestBody Venue v) {
        // Hämta den befintliga kunden
         Venue existingVenue = venueService.findById(id);

        // Uppdatera fälten i den befintliga kunden
        existingVenue.setName(v.getName());
        existingVenue.setMaxNoOfGuests(v.getMaxNoOfGuests());
        existingVenue.setFacilities(v.getFacilities());

        return venueService.save(existingVenue);
    }
}
