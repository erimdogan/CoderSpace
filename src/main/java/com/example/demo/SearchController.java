package com.example.demo;

import com.example.demo.airports.AirportRepository;
import com.example.demo.flights.FlightRepository;
import com.example.demo.flights.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    @Autowired
    public SearchController(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @GetMapping
    public ResponseEntity<List<Flights>> searchFlights(
            @RequestParam("departureAirport") String departureAirport,
            @RequestParam("arrivalAirport") String arrivalAirport,
            @RequestParam("departureDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam(value="returnDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDate
    ) {
        List<Flights> flights;

        if (returnDate != null){
            flights = flightRepository.findByDepartureAirportAndArrivalAirPortAndDepartureDateTimeAndArrivalDateTime(departureAirport, arrivalAirport, departureDateTime, returnDate);
        } else {
            flights = flightRepository.findByDepartureAirportAndArrivalAirPortAndDepartureDateTime(departureAirport, arrivalAirport, departureDateTime);
        }
        return ResponseEntity.ok(flights);
    }
}