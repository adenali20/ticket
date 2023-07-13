package com.example.ticket.service;

import com.example.ticket.domain.Airport;
import com.example.ticket.repository.AirportRepository;
import com.example.ticket.service.interfaces.IAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService implements IAirport {
    @Autowired
    AirportRepository airportRepository;

    public Airport save(Airport newAirport){
        Airport airport=findAirportByCode(newAirport.getCode());

        if(airport==null){
            airport= airportRepository.save(newAirport);
        }else{
            newAirport.setId(airport.getId());
            airport= airportRepository.save(newAirport);
        }

        return airport;
    }

    @Override
    public Airport findAirportByCode(String code) {
        Airport airport=airportRepository.findAirportByCode(code);
        return airport;
    }

    @Override
    public Airport delete(Airport entity) {
        return airportRepository.delete(entity);
    }

    @Override
    public void deleteAirportByCode(String code) {
         airportRepository.deleteAirportByCode(code);
         return;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }
}
