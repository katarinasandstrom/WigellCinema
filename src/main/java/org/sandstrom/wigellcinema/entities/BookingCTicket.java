package org.sandstrom.wigellcinema.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bookingCinemaTicket")
public class BookingCTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


   @ManyToOne
    private Customer customer;

   @ManyToOne Screening screening;

   @Column(name= "nr_of_tickets")
    private int nrOfTickets;

   @Column (name= "total_price_SEK")
    private BigDecimal totalPriceSEK;


   public BookingCTicket(){

   }
    public BookingCTicket(int id, Customer customer, Screening screening, int nrOfTickets, BigDecimal totalPriceSEK) {
        this.id = id;
        this.customer = customer;
        this.screening = screening;
        this.nrOfTickets = nrOfTickets;
        this.totalPriceSEK = totalPriceSEK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public int getNrOfTickets() {
        return nrOfTickets;
    }

    public void setNrOfTickets(int nrOfTickets) {
        this.nrOfTickets = nrOfTickets;
    }

    public BigDecimal getTotalPriceSEK() {
        return totalPriceSEK;
    }

    public void setTotalPriceSEK(BigDecimal totalPriceSEK) {
        this.totalPriceSEK = totalPriceSEK;
    }


    @Override
    public String toString() {
        return "BookingCinemaTicket{" +
                "id=" + id +
                ", customer=" + customer +
                ", screening=" + screening +
                ", nrOfTickets=" + nrOfTickets +
                ", totalPriceSEK=" + totalPriceSEK +
                '}';
    }
}
