package com.example.ticket.controller;

import com.example.ticket.domain.Airline;
import com.example.ticket.domain.User;
import com.example.ticket.dto.AuthenticationRequest;
import com.example.ticket.dto.AuthenticationResponse;
import com.example.ticket.service.AirlineService;
import com.example.ticket.service.MyUserDetailsService;
import com.example.ticket.service.UserService;
import com.example.ticket.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(
//        origins={"*"},
//        methods = {
//                RequestMethod.POST,RequestMethod.GET
//        }
//)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;


    @PostMapping("/")
    public User save(@Valid @RequestBody User user, Authentication authentication){
        user.setUsername("USER");
        User user1=userService.save(user);
        return user1;
    }

    @PostMapping("/admin/save")
    public User saveUser(@Valid @RequestBody User user){
        User user1=userService.save(user);
        return user1;
    }

    @GetMapping("/admin/hello")
    public String sayHi(){
        return "hello guys";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }






}
