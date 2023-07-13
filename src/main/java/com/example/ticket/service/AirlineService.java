package com.example.ticket.service;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.Airline;
import com.example.ticket.repository.AddressRepository;
import com.example.ticket.repository.AirlineRepository;
import com.example.ticket.service.interfaces.IAddress;
import com.example.ticket.service.interfaces.IAirline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService implements IAirline {

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public Airline save(Airline entity) {
        Airline airline=findAirlineByCode(entity.getCode());
        if(airline==null) airline=entity;
        return airlineRepository.save(airline);
    }

    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline findAirlineByCode(String code) {
        return airlineRepository.findAirlineByCode(code);
    }
}
