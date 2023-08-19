package com.example.demo;

import com.example.demo.flights.FlightRepository;
import com.example.demo.flights.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FlightDataUpdater {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightDataUpdater(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void updateFlightData() {
        Flights mockFlight1 = new Flights();
        mockFlight1.setDepartureAirport("New York");
        mockFlight1.setArrivalAirPort("Los Angeles");
        mockFlight1.setDepartureDateTime(LocalDateTime.parse("2023-08-19T08:00:00"));
        mockFlight1.setReturnDateTime(LocalDateTime.parse("2023-08-21T08:00:00"));
        mockFlight1.setPrice(200.0);
        flightRepository.save(mockFlight1);

        Flights mockFlight2 = new Flights();
        mockFlight2.setDepartureAirport("New York");
        mockFlight2.setArrivalAirPort("Paris");
        mockFlight2.setDepartureDateTime(LocalDateTime.parse("2023-08-20T10:00:00"));
        mockFlight2.setReturnDateTime(LocalDateTime.parse("2023-08-25T15:00:00"));
        mockFlight2.setPrice(300.0);
        flightRepository.save(mockFlight2);
    }
}
