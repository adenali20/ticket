package com.example.ticket.controller;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.Airline;
import com.example.ticket.domain.Airport;
import com.example.ticket.service.AddressService;
import com.example.ticket.service.AirlineService;
import com.example.ticket.service.AirportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @PostMapping("/")
    public Airline save(@Valid @RequestBody Airline airline){
        Airline airline1=airlineService.save(airline);
        return airline1;
    }

    @GetMapping("/code/{code}")
    @Cacheable(value = "Airline", key = "#code")
    public Airline findByCode(@PathVariable("code") String code){
        Airline airline=airlineService.findAirlineByCode(code);
        return airline;
    }




}
