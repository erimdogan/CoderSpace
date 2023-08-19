package com.example.demo.flights;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flights, Long> {


    List<Flights> findByDepartureAirportAndArrivalAirPortAndDepartureDateTime(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime);

    List<Flights> findByDepartureAirportAndArrivalAirPortAndDepartureDateTimeAndArrivalDateTime(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime returnDate);
}