package com.example.demo;

import com.example.demo.flights.FlightRepository;
import com.example.demo.flights.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/flights")
    public List<Flights> searchFlights(
            @RequestParam String departureAirport,
            @RequestParam String arrivalAirport,
            @RequestParam("departureDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam(value="returnDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDateTime) {

        if (returnDateTime != null) {
            // Round-trip flights
            return flightRepository.findRoundTripFlights(departureAirport, arrivalAirport, departureDateTime, returnDateTime);
        } else {
            // One-way flights
            return flightRepository.findOneWayFlights(departureAirport, arrivalAirport, departureDateTime);
        }
    }
}