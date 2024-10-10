package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.dao.CustomerRepository;
import org.sandstrom.wigellcinema.dao.MovieRepository;
import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{



    private MovieRepository movieRepository;

   @Autowired
   public MovieServiceImpl(MovieRepository movieRep){
       movieRepository = movieRep;
   }

   @Override
   public List<Movie> findAll() {
       return movieRepository.findAll();
   }

   @Override
   public Movie findById(int id) {
       Optional<Movie> m = movieRepository.findById(id);
       Movie movie = null;
       if (m.isPresent()) {
           movie = m.get();
       } else {
           throw new RuntimeException("Film med id " + id + " hittades inte.");
       }
       return movie;
   }

   @Override
   public Movie save (Movie movie){
       return movieRepository.save(movie);
   }

   @Override
   public void deleteById(int id) {
       movieRepository.deleteById(id);
   }
}
