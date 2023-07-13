package com.example.ticket.controller;

import com.example.ticket.domain.*;
import com.example.ticket.repository.FlightRepository;
import com.example.ticket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    FlightService flightService;


    @Autowired
    PersonService personService;

    @Autowired
    ReservationService reservationService;




    @PostMapping("/save")
    public String save(@RequestBody Reservation reservation){
        Person person=personService.save(reservation.getPerson());

        List<Flight> flightList=new ArrayList<>();
        reservation.getFlights().stream().forEach(flight -> {
            flightList.add(flightService.findFlightByNumber(flight.getNumber()));
        });
        reservation.setPerson(person);
        reservation.setFlights(flightList);
        reservation.setStatus("InProgress");
        reservation.setReserverEmail(person.getEmail());
        reservationService.save(reservation);


        return "reservation saved";
    }

    @GetMapping("/findAll")
    public List<Reservation> findAll(){
       List<Reservation> reservationList=reservationService.findAll();
        return reservationList;
    }






}
