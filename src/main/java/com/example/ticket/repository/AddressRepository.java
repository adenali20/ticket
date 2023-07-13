package com.example.ticket.repository;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.Airport;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface AddressRepository extends Repository<Address, Integer> {
    Address save(Address entity);
    Address findAddressByCityAndStreet(String city,String street);
}
