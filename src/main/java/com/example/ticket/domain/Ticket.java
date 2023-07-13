package com.example.ticket.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Ticket {
//    A Ticket has an id, number (twenty-digit number), reservation code (6 character alphanumeric),
//flight date and connects a passenger to a single flight.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String number;

    @ManyToOne
    Reservation reservation;

}
