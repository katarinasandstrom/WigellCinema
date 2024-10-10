package org.sandstrom.wigellcinema.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Facility {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;

    @Column (name= "description")
    private String description;


    public Facility(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Facility(){

    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

