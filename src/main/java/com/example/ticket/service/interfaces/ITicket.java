package com.example.ticket.service.interfaces;

import com.example.ticket.domain.Reservation;
import com.example.ticket.domain.Ticket;

import java.util.List;

public interface ITicket {
    Ticket save(Ticket entity);
    List<Ticket> findTicketByReservation(Reservation reservation);

}
