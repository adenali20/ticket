package com.example.ticket.service;

import com.example.ticket.domain.Reservation;
import com.example.ticket.domain.Ticket;
import com.example.ticket.repository.ReservationRepository;
import com.example.ticket.repository.TicketRepository;
import com.example.ticket.service.interfaces.IReservation;
import com.example.ticket.service.interfaces.ITicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicket {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket save(Ticket entity) {

        return ticketRepository.save(entity);
    }

    @Override
    public List<Ticket> findTicketByReservation(Reservation reservation) {
        return ticketRepository.findTicketByReservation(reservation);
    }


}
