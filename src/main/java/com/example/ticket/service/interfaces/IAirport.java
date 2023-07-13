package com.example.ticket.service.interfaces;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.Airport;

import java.util.List;

public interface IAirport {
    Airport save(Airport entity);
    Airport findAirportByCode(String code);
    Airport delete(Airport entity);
    void deleteAirportByCode(String entity);
    List<Airport> findAll();
}
