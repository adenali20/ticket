package com.example.ticket.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    //An Airport has an id,
    // a three-letter code (e.g. CID), name (“Eastern Iowa Airport”) and Address
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String code;
    String name;


    @OneToOne
    @Cascade({CascadeType.ALL})
    Address address;


}
