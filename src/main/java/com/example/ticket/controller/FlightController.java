package com.example.ticket.controller;

import com.example.ticket.domain.Airline;
import com.example.ticket.domain.Airport;
import com.example.ticket.domain.Flight;
import com.example.ticket.repository.FlightRepository;
import com.example.ticket.service.AirlineService;
import com.example.ticket.service.AirportService;
import com.example.ticket.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirportService airportService;
    @Autowired
    FlightRepository flightRepository;


    @PostMapping("/saveAll")
    public String saveAll(@RequestBody List<Flight> flightList){
        flightList.stream().forEach(e->{
            Airline airline=airlineService.findAirlineByCode(e.getAirline().getCode());
            e.setAirline(airline);
            flightService.save(e);
        });

        return "airline";
    }

    @PostMapping("/save")
    public Flight save(@RequestBody Flight flight){
        Airline airline=airlineService.findAirlineByCode(flight.getAirline().getCode());
        flight.setAirline(airline);
        flightService.save(flight);

        return flightService.save(flight);
    }

    @GetMapping("/findAll")
    public List<Flight> findAll(){
        return flightService.findAll();
    }

    @GetMapping("/departureAirport/{code}")
    public List<Flight> findFlightsByDepatureAirport(@PathVariable String code){
        Airport airport=airportService.findAirportByCode(code);

        List<Flight> flightList=flightRepository.findFlightByDepartureAirport(airport);

        return flightList;
    }

    @GetMapping("/departureAirport/{code}/arrivalAirport/{code2}/{localDate}")
    public List<List<Flight>> findFlightsByDepatureAndArrivalAirport(@PathVariable String code,@PathVariable String code2,
                                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate){
        Airport airport=airportService.findAirportByCode(code);
        Airport airport2=airportService.findAirportByCode(code2);

       return flightService.findFlightByDepartureAirportAndArrivalAirportAndDepartureDate(airport,airport2,localDate);

    }

}
