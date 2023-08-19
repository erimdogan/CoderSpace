package com.example.demo ;

import com.example.demo.airports.AirportRepository;
import com.example.demo.airports.Airports;
import com.example.demo.flights.FlightRepository;
import com.example.demo.flights.Flights;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(FlightRepository flightRepository, AirportRepository airportRepository) {
        return args -> {
            Flights flight1 = new Flights();
            flight1.setDepartureAirport("SEA");
            flight1.setArrivalAirPort("SFO");
            flight1.setDepartureDateTime(LocalDateTime.parse("2020-01-01T00:00:00"));
            flight1.setReturnDateTime(LocalDateTime.parse("2020-01-01T01:00:00"));
            flight1.setPrice(100.00);
            flightRepository.save(flight1);

            Flights flight2 = new Flights();
            flight2.setDepartureAirport("LAX");
            flight2.setArrivalAirPort("JFK");
            flight2.setDepartureDateTime(LocalDateTime.parse("2023-08-19T15:00:00"));
            flightRepository.save(flight2);


            Airports airport1 = new Airports();
            airport1.setId(1L);
            airport1.setCity("Seattle");
            airportRepository.save(airport1);

            Airports airport2 = new Airports();
            airport2.setId(2L);
            airport2.setCity("San Francisco");
            airportRepository.save(airport2);
        };
    }
}