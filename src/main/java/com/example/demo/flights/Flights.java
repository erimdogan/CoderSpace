package com.example.demo.flights;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Flights{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DepartureAirport;
    private String ArrivalAirPort;
    private LocalDateTime arrivalDateTime;
    private LocalDateTime departureDateTime;
    double price;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return DepartureAirport;
    }
    public void setDepartureAirport(String DepartureAirport) {
        this.DepartureAirport = DepartureAirport;
    }

    public String getArrivalAirPort() {
        return ArrivalAirPort;
    }
    public void setArrivalAirPort(String ArrivalAirPort) {
        this.ArrivalAirPort = ArrivalAirPort;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }
    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }
    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
