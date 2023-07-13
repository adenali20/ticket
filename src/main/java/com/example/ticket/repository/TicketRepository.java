package com.example.ticket.repository;

import com.example.ticket.domain.Reservation;
import com.example.ticket.domain.Ticket;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface TicketRepository extends Repository<Ticket, Integer> {
    Ticket save(Ticket entity);
    List<Ticket> findTicketByReservation(Reservation reservation);
}
