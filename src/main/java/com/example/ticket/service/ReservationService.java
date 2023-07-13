package com.example.ticket.service;

import com.example.ticket.domain.Person;
import com.example.ticket.domain.Reservation;
import com.example.ticket.repository.PersonRepository;
import com.example.ticket.repository.ReservationRepository;
import com.example.ticket.service.interfaces.IPerson;
import com.example.ticket.service.interfaces.IReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservation {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation entity) {
        Reservation reservation=findReservationByCode(entity.getCode());
        if(reservation==null){
            reservation=entity;
        }
        return reservationRepository.save(reservation) ;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findReservationByCode(String code) {
        return reservationRepository.findReservationByCode(code);
    }

    @Override
    public Reservation findReservationByreserverEmail(String email) {
        return null;
    }
}
