package com.example.ticket.repository;

import com.example.ticket.domain.Airport;
import com.example.ticket.domain.Flight;
import com.example.ticket.domain.Reservation;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface ReservationRepository extends Repository<Reservation, Integer> {
    Reservation save(Reservation entity);
    List<Reservation> findAll();
    Reservation findReservationByCode(String code);
    Reservation findReservationByreserverEmail(String email);
}
