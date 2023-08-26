package com.example.ticket.repository;

import com.example.ticket.domain.Address;
import com.example.ticket.domain.User;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Long> {
    User save(User entity);
    User findUserByUsername(String username);

}
