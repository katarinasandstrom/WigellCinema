package org.sandstrom.wigellcinema.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Movie movie;

    @Enumerated(EnumType.STRING)
    @Column(name = "venue")
    private Venue venue;

    @Column(name="screening_time")
    private LocalDateTime screeningTime;

    public Screening(Movie movie, Venue venue, LocalDateTime screeningTime) {
        this.movie = movie;
        this.venue = venue;
        this.screeningTime = screeningTime;
    }

    public Screening() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getFilm() {
        return movie;
    }

    public void setFilm(Movie movie) {
        this.movie = movie;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public LocalDateTime getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(LocalDateTime screeningTime) {
        this.screeningTime = screeningTime;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", film=" + movie +
                ", venue=" + venue +
                ", screeningTime=" + screeningTime +
                '}';
    }
}

