package com.example.ticket.repository;

import com.example.ticket.domain.Airline;
import com.example.ticket.domain.Airport;
import com.example.ticket.domain.Flight;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Repository
public interface FlightRepository extends Repository<Flight, Integer> {
    Flight save(Flight entity);
    Flight findFlightByNumber(int number);
    List<Flight> findFlightByDepartureAirport(Airport airport);
    List<Flight> findFlightByDepartureAirportAndAirline(Airport airport, Airline airline);
    List<Flight> findFlightByDepartureAirportAndArrivalAirportAndDepartureDate(Airport departureAirport,
                                                                               Airport arrivalAirport,
                                                                               LocalDate departureDate);

    List<Flight> findAll();

}
