package com.example.ticket.service.interfaces;

import com.example.ticket.domain.Airline;
import com.example.ticket.domain.Airport;
import com.example.ticket.domain.Flight;

import java.time.LocalDate;
import java.util.List;

public interface IFlight {
    Flight save(Flight entity);
    List<Flight> findAll();
    Flight findFlightByNumber(int number);
    List<Flight> findFlightByDepartureAirportAndAirline(Airport airport, Airline airline);
    List<Flight> findFlightByDepartureAirport(Airport airport);
    List<List<Flight>> findFlightByDepartureAirportAndArrivalAirportAndDepartureDate(Airport departureAirport,
                                                                               Airport arrivalAirport,
                                                                               LocalDate departureDate);
}
