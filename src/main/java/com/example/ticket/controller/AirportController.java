package com.example.ticket.controller;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.Airport;
import com.example.ticket.service.AddressService;
import com.example.ticket.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @Autowired
    AddressService addressService;

    @PostMapping("/saveAll")
    public String saveAll(@RequestBody List<Airport> list){

        list.stream().forEach(e->{
            Address address=e.getAddress();
            addressService.save(e.getAddress());

            e.setAddress(address);
            airportService.save(e);

        });
        return "saved";
    }
    @PostMapping("/")
    public Airport save(@RequestBody Airport airport){
        Airport airport1=airportService.findAirportByCode(airport.getCode());
        airportService.save(airport1);
        return airport;
    }

    @DeleteMapping("/code/{code}")
    public Airport deleteByCode(@PathVariable("code") String code){
        Airport airport=airportService.findAirportByCode(code);
        airportService.delete(airport);
        return airport;
    }

    @GetMapping("/")
    public Airport find(@RequestBody Airport airport){


        return airportService.findAirportByCode(airport.getCode());
    }

    @GetMapping("/findAll")
    public List<Airport> findAll(){


        return airportService.findAll();
    }


}
