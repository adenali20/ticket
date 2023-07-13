package com.example.ticket.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Reservation {
//    A Reservation connects a passenger to multiple flights to get the passenger from point A to B

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String code;


    @ManyToOne
    Person person;

    @OneToMany
    List<Flight> flights;


    String reserverEmail;

    String status;




}
