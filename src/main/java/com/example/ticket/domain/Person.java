package com.example.ticket.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Person {
//    A Passenger has an id, first name, last name, date of birth, email address and residence address

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String firstName;
    String lastName;
    LocalDate dateOfBirth;
    String email;

    @ManyToOne
    Address address;
}
