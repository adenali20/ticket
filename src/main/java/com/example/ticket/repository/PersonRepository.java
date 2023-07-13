package com.example.ticket.repository;

import com.example.ticket.domain.Airport;
import com.example.ticket.domain.Flight;
import com.example.ticket.domain.Person;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface PersonRepository extends Repository<Person, Integer> {
    Person save(Person entity);
    Person findPersonByEmail(String email);


}
