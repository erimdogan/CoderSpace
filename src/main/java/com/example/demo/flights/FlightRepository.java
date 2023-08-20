package com.example.demo.flights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flights, Long> {

    @Query("SELECT f FROM Flights f WHERE f.departureAirport = :departure AND f.arrivalAirPort = :arrival AND f.departureDateTime = :departureDate")
    List<Flights> findOneWayFlights(String departure, String arrival, LocalDateTime departureDate);

    @Query("SELECT f FROM Flights f WHERE f.departureAirport= :departure AND f.arrivalAirPort = :arrival AND f.departureDateTime = :departureDate AND f.returnDateTime = :returnDate")
    List<Flights> findRoundTripFlights(String departure, String arrival, LocalDateTime departureDate, LocalDateTime returnDate);
}