package com.example.ticket.controllerAdvice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ErrorMessage {
    String message;

//    Map<String,String> error;
//    Map<String,String> er2;
    List<String> error;



}
