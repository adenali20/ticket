package com.example.ticket.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
public class Flight {
//    A Flight has an id, number (“1248”), capacity (number of seats), belongs to an Airline and is
//    between a departure Airport and an arrival airport. Also, has a departure & arrival time.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int number;
    int capacity;

    @ManyToOne
    Airline airline;

    @ManyToOne
    Airport departureAirport;

    @ManyToOne
    Airport arrivalAirport;


    @Temporal(TemporalType.DATE)
    LocalDate departureDate;


    @Temporal(TemporalType.DATE)
    LocalDate arrivalDate;

    @Temporal(TemporalType.TIME)
    LocalTime departureTime;


    @Temporal(TemporalType.TIME)
    LocalTime arrivalTime;













}
