package com.example.ticket.service;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.User;
import com.example.ticket.repository.AddressRepository;
import com.example.ticket.repository.UserRepository;
import com.example.ticket.service.interfaces.IAddress;
import com.example.ticket.service.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUser {


    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
