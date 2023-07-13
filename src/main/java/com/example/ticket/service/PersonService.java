package com.example.ticket.service;

import com.example.ticket.domain.Flight;
import com.example.ticket.domain.Person;
import com.example.ticket.repository.FlightRepository;
import com.example.ticket.repository.PersonRepository;
import com.example.ticket.service.interfaces.IFlight;
import com.example.ticket.service.interfaces.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPerson {

    @Autowired
    PersonRepository personRepository;
    @Override
    public Person save(Person entity) {
        Person person = findPersonByEmail(entity.getEmail());
        if(person==null){
            person=entity;
        }
        return personRepository.save(person);
    }

    @Override
    public Person findPersonByEmail(String email) {
        return personRepository.findPersonByEmail(email);
    }
}
