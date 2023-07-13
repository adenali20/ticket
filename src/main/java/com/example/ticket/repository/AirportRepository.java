package com.example.ticket.repository;

import com.example.ticket.domain.Airport;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AirportRepository extends Repository<Airport, Integer> {
    Airport save(Airport entity);
    Airport delete(Airport entity);
    Airport findAirportByCode(String code);
    List<Airport> findAll();
    void deleteAirportByCode(String code);

}
