package com.example.ticket.service.interfaces;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.Airline;

import java.util.List;

public interface IAirline {
    Airline save(Airline entity);
    List<Airline> findAll();
    Airline findAirlineByCode(String code);

}
