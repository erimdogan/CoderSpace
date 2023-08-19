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
    private String departureAirport;
    private String arrivalAirPort;
    private LocalDateTime returnDateTime;
    private LocalDateTime departureDateTime;
    double price;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }
    public void setDepartureAirport(String DepartureAirport) {
        this.departureAirport = DepartureAirport;
    }

    public String getArrivalAirPort() {
        return arrivalAirPort;
    }
    public void setArrivalAirPort(String ArrivalAirPort) {
        this.arrivalAirPort = ArrivalAirPort;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }
    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
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
