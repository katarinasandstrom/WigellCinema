package org.sandstrom.wigellcinema.dao;

import org.sandstrom.wigellcinema.entities.Customer;
import org.sandstrom.wigellcinema.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
