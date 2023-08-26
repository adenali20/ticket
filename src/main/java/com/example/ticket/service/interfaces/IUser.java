package com.example.ticket.service.interfaces;

import com.example.ticket.domain.User;

public interface IUser {
    User save(User entity);
    User findUserByUsername(String username);

}
