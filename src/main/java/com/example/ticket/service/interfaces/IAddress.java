package com.example.ticket.service.interfaces;

import com.example.ticket.domain.Address;

public interface IAddress {
    Address save(Address entity);
    Address findAddressByCityAndStreet(String city,String street);

}
