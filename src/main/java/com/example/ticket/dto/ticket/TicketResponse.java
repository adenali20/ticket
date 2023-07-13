package com.example.ticket.dto.ticket;

import lombok.Data;

@Data
public class TicketResponse {
    //    A Ticket has an id, number (twenty-digit number), reservation code (6 character alphanumeric),
//flight date and connects a passenger to a single flight.

    String number;
    String reservationCode;

}
