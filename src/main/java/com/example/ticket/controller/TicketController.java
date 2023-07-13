package com.example.ticket.controller;

import com.example.ticket.domain.Flight;
import com.example.ticket.domain.Person;
import com.example.ticket.domain.Reservation;
import com.example.ticket.domain.Ticket;
import com.example.ticket.dto.ticket.TicketResponse;
import com.example.ticket.repository.TicketRepository;
import com.example.ticket.service.FlightService;
import com.example.ticket.service.PersonService;
import com.example.ticket.service.ReservationService;
import com.example.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;


    @Autowired
    PersonService personService;

    @Autowired
    ReservationService reservationService;




    @PostMapping("/confirm")
    public String save(@RequestBody Reservation request){
       Reservation reservation=reservationService.findReservationByCode(request.getCode());

       reservation.setStatus("Confirmed");
       reservation.getFlights().stream().forEach(flight -> {
           Ticket ticket=new Ticket();
           ticket.setReservation(reservation);
           UUID uuid = UUID.randomUUID();
           ticket.setNumber(""+uuid);
           ticketService.save(ticket);
       });

       //send Email

        return "Ticket generated ";
    }

    @GetMapping("/findByReservation")
    public List<TicketResponse> findByReservation(@RequestBody Reservation request){
        Reservation reservation=reservationService.findReservationByCode(request.getCode());
        List<TicketResponse> ticketResponses=new ArrayList<>();
        ticketService.findTicketByReservation(reservation).stream().forEach(ticket -> {
            TicketResponse ticketResponse=new TicketResponse();
            ticketResponse.setNumber(ticket.getNumber());
            ticketResponse.setReservationCode(request.getCode());
            ticketResponses.add(ticketResponse);
        });

        return ticketResponses;
    }






}
