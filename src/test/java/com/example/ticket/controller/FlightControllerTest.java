package com.example.ticket.controller;


import com.example.ticket.domain.Airline;
import com.example.ticket.domain.Flight;
import com.example.ticket.service.AirlineService;
import com.example.ticket.service.FlightService;
import com.example.ticket.service.LocalDateTypeAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class FlightControllerTest {

    @MockBean
    FlightService flightService;

    @MockBean
    AirlineService airlineService;

    @Autowired
    Gson gson;



    @Autowired
    MockMvc mockMvc;


    @Test
    public void testSaveFlight() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Flight flight=objectMapper.readValue("{\"airline\":{\"code\":\"AA\"},\"number\":\"551\",\"departureAirport\":{\"code\":\"LAS\"},\"departureDate\":\"2023-07-10T05:51:00.000Z\",\"departureTime\":\"00:51\",\"arrivalAirport\":{\"code\":\"ORD\"},\"arrivalDate\":\"2023-07-10T05:51:00.000Z\",\"arrivalTime\":\"00:51\"}",
        Flight.class);
        Airline airline=gson.fromJson("{\"code\":\"AA\"}",Airline.class);
        when(airlineService.findAirlineByCode(any())).thenReturn(airline);
        when(flightService.save(flight)).thenReturn(flight);

        mockMvc.perform(post("/flight/save")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(flight)))
                .andExpect(status().isOk());
    }
}
