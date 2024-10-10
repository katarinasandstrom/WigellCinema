package org.sandstrom.wigellcinema.controllers;


import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.entities.Movie;
import org.sandstrom.wigellcinema.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class MovieController {
    private MovieService movieService;

    public MovieController (MovieService movieSer){
        movieService = movieSer;
    }

    @GetMapping("/v1/movies")
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @PostMapping("/v1/movies")
    public Movie addMovie(@RequestBody Movie m) {
        m.setId(0);
        return movieService.save(m);
    }

    @DeleteMapping ("v1/movies/{id}")
    public String deleteMovie(@PathVariable int id){
        Movie movie = movieService.findById(id);
        if (movie == null){
            throw new RuntimeException("Film med id: " + id + " hittades inte.");
        }
        movieService.deleteById(id);
        return "Film med id: " + id + " är raderad.";
    }
    @PutMapping("/v1/movies/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie m) {
        // Hämta den befintliga kunden
        Movie existingMovie = movieService.findById(id);

        // Uppdatera fälten i den befintliga kunden
        existingMovie.setTitle(m.getTitle());
        existingMovie.setLength(m.getLength());
        existingMovie.setGenre(m.getGenre());
        existingMovie.setAgeLimit(m.getAgeLimit());
        //adress


        return movieService.save(existingMovie);
    }

}
