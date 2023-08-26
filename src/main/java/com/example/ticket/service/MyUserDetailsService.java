package com.example.ticket.service;

import com.example.ticket.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    MyUserDetails myUserDetails;

    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userService.findUserByUsername(username);
        myUserDetails.setUsername(user.getUsername());
        myUserDetails.setPassword(user.getPassword());

        List<SimpleGrantedAuthority> s=new ArrayList<>();

        Arrays.stream(user.getRole().split(",")).forEach(e->{
            s.add(new SimpleGrantedAuthority("ROLE_"+e));
        });

        myUserDetails.setAuthorities(s);

        return myUserDetails;
    }
}
