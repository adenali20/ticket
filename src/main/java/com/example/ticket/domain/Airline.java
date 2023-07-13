package com.example.ticket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Data
public class Airline implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;
//    An Airline has an id, code (“UA”), name (“United Airlines”) and history (history is a maximum of
//            2000 characters and is saved in a separate table in database)

    @Digits(integer=6, fraction=2)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull(message = "code Cannot be empty")
    String code;

    @NotNull(message="name Cannot be empty")
    String name;
    String history;
}
