package org.sandstrom.wigellcinema.dao;



import org.sandstrom.wigellcinema.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer> {
}