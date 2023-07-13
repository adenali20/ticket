package com.example.ticket.service;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.Airport;
import com.example.ticket.repository.AddressRepository;
import com.example.ticket.repository.AirportRepository;
import com.example.ticket.service.interfaces.IAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddress {

    @Autowired
    AddressRepository addressRepository;

    public Address save(Address newAddress){
        Address address=findAddressByCityAndStreet(newAddress.getCity(),newAddress.getStreet());

        if(address==null){
           address= addressRepository.save(newAddress);

        }else{
            newAddress.setId(address.getId());
            address= addressRepository.save(newAddress);
        }
        return address;
    }

    @Override
    public Address findAddressByCityAndStreet(String city, String street) {
        Address address=addressRepository.
                findAddressByCityAndStreet(city,street);
        return address;
    }
}
