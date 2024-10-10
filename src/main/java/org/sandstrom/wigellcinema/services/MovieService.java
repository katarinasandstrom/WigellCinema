package org.sandstrom.wigellcinema.services;

import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.entities.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    Movie findById(int id);

    Movie save(Movie movie);

    void deleteById(int id);
}
