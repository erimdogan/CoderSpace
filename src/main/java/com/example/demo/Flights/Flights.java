package com.example.demo.Flights;

import java.persistence.Entity;
import java.persistence.Id;
import java.persistence.GeneratedValue;
import java.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class Flights {
    @Id
    @GenerateValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private double price;
}
