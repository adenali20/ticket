package com.example.ticket.service.interfaces;

import com.example.ticket.domain.Flight;
import com.example.ticket.domain.Person;

import java.util.List;

public interface IPerson {
    Person save(Person entity);
    Person findPersonByEmail(String email);

}
