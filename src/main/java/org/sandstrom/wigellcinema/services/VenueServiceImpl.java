package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.dao.CustomerRepository;
import org.sandstrom.wigellcinema.dao.VenueRepository;
import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.entities.Movie;
import org.sandstrom.wigellcinema.entities.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueServiceImpl implements VenueService{

    private VenueRepository venueRepository;
    @Autowired
    public VenueServiceImpl(VenueRepository venueRep){
        venueRepository = venueRep;
    }


    @Override
    public List<Venue> findAll(){
        return venueRepository.findAll();
    }


    @Override
    public Venue findById(int id){
        Optional<Venue> v = venueRepository.findById(id);
        Venue venue = null;
        if(v.isPresent()){
            venue = v.get();
        }
        else{
            throw new RuntimeException("Venue with id  " + id + " was not found.");
        }
        return venue;
    }

    @Override
    public Venue save (Venue venue){
            return venueRepository.save(venue);
        }

    @Override
    public void deleteById(int id){

            venueRepository.deleteById(id);
        }
}

