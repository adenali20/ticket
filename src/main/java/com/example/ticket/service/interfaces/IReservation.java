package com.example.ticket.service.interfaces;

import com.example.ticket.domain.Person;
import com.example.ticket.domain.Reservation;

import java.util.List;

public interface IReservation {
    Reservation save(Reservation entity);
    List<Reservation> findAll();
    Reservation findReservationByCode(String code);
    Reservation findReservationByreserverEmail(String email);

}
