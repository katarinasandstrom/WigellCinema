package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.dao.CustomerRepository;
import org.sandstrom.wigellcinema.dao.MovieRepository;
import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.entities.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);

    private MovieRepository movieRepository;

   @Autowired
   public MovieServiceImpl(MovieRepository movieRep){
       movieRepository = movieRep;
   }

   @Override
   public List<Movie> findAll() {
       logger.info("All movies was listed.");
       return movieRepository.findAll();
   }

   @Override
   public Movie findById(int id) {
       Optional<Movie> m = movieRepository.findById(id);
       Movie movie = null;
       if (m.isPresent()) {
           movie = m.get();
       } else {
           throw new RuntimeException("Movie with " + id + " could not be found.");
       }
       logger.info("Movie with id " + id + " was listed.");
   return movie;
   }

   @Override
   public Movie save (Movie movie){
       String savedMovie = movieRepository.save(movie).getTitle();
       logger.info("Movie " + savedMovie+ " was added by admin.");
       return movieRepository.save(movie);
   }

   @Override
   public void deleteById(int id) {

       Optional <Movie> optionalMovie = movieRepository.findById(id);

       if(optionalMovie.isPresent()){
           Movie movieToDelete = optionalMovie.get();
           movieRepository.deleteById(id);
           logger.info("Movie " + movieToDelete.getTitle() + " was deleted by admin." );
       }
       else {
           logger.warn("Attempted to delete movie with id " + id + " but it was not found.");
       }
   }
}
