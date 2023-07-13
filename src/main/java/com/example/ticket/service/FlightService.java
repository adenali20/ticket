package com.example.ticket.service;

import com.example.ticket.domain.Airline;
import com.example.ticket.domain.Airport;
import com.example.ticket.domain.Flight;
import com.example.ticket.repository.AirportRepository;
import com.example.ticket.repository.FlightRepository;
import com.example.ticket.service.interfaces.IAirport;
import com.example.ticket.service.interfaces.IFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class FlightService implements IFlight {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirportService airportService;

    @Autowired
    AirlineService airlineService;

    @Override
    public Flight save(Flight entity) {
        Flight flight=flightRepository.findFlightByNumber(entity.getNumber());
        if(flight==null){
            flight=entity;
        }
        flight.setAirline(airlineService.findAirlineByCode(flight.getAirline().getCode()));
        flight.setDepartureAirport(airportService.findAirportByCode(flight.getDepartureAirport().getCode()));
        flight.setArrivalAirport(airportService.findAirportByCode(flight.getArrivalAirport().getCode()));


        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findFlightByDepartureAirportAndAirline(Airport airport, Airline airline) {
        return flightRepository.findFlightByDepartureAirportAndAirline(airport,airline);
    }

    public void util(Flight flight,List<String> visiting, List<Flight> path,List<List<Flight>> routes,Airport destination){

        path.add(flight);
        if(flight.getArrivalAirport().getCode().equals(destination.getCode())){
            routes.add(path);
            return;
        }


        visiting.add(flight.getDepartureAirport().getCode());
        List<Flight> flightList=findFlightByDepartureAirportAndAirline(flight.getArrivalAirport(),flight.getAirline());


        for(Flight f : flightList){
            if(!visiting.contains(f.getArrivalAirport().getCode()) ){
                util(f,new ArrayList<>(visiting),new ArrayList<>(path),routes,destination);
            }
        }

    }



    @Override
    public List<Flight> findFlightByDepartureAirport(Airport airport) {
        return flightRepository.findFlightByDepartureAirport(airport);
    }

    @Override
    public List<List<Flight>> findFlightByDepartureAirportAndArrivalAirportAndDepartureDate(Airport departureAirport, Airport arrivalAirport, LocalDate departureDate) {
        List<Flight> flightList=findFlightByDepartureAirport(departureAirport);
        List<List<Flight>> list=new ArrayList<>();
        for(Flight flight:flightList){

            util(flight,new ArrayList<>(),new ArrayList<>(),list,arrivalAirport);
        }


        return list;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findFlightByNumber(int number) {
        Flight flight=flightRepository.findFlightByNumber(number);
        return flight;
    }
}
