package com.example.ticket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("settinh cors");
        registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000","http://localhost:8080","http://localhost","*")
               .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");



    }


}