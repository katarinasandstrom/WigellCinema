package org.sandstrom.wigellcinema.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name; // Namn på lokalen, t.ex. "Salong 1"

    @Column(name="max_nr_of_guests")
    private int maxNoOfGuests; // Max antal gäster lokalen kan rymma.

    @ManyToMany
    @JoinTable(
            name = "venue_facilities",
            joinColumns = @JoinColumn(name = "venue_id"),
            inverseJoinColumns = @JoinColumn(name = "facility_id")
    )
    private List<Facility> facilities; // Lista över faciliteter (teknisk utrustning) som finns i lokalen.

    @OneToMany(mappedBy = "venue")
    private List<Screening> screenings; // Lista över föreställningar som hålls i lokalen.

    public Venue(){

    }
    public Venue(String name, int maxNoOfGuests, List<Facility> facilities, List<Screening> screenings) {
        this.name = name;
        this.maxNoOfGuests = maxNoOfGuests;
        this.facilities = facilities;
        this.screenings = screenings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxNoOfGuests() {
        return maxNoOfGuests;
    }

    public void setMaxNoOfGuests(int maxNoOfGuests) {
        this.maxNoOfGuests = maxNoOfGuests;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxNoOfGuests=" + maxNoOfGuests +
                ", facilities=" + facilities +
                ", screenings=" + screenings +
                '}';
    }
}
