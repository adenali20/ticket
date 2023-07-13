package com.example.ticket.repository;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.Airline;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AirlineRepository extends Repository<Airline, Integer> {
    Airline save(Airline entity);
    List<Airline> findAll();
    Airline findAirlineByCode(String code);
}
