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
    public List<Flights> getFlights(
            @RequestParam(required = false, name = "departureAirport") String departureAirport,
            @RequestParam(required = false, name = "arrivalAirport") String arrivalAirport,
            @RequestParam(required = false, name = "departureDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam(value = "returnDateTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDateTime) {


        System.out.println("departureAirport: " + departureAirport);
        System.out.println("arrivalAirport: " + arrivalAirport);
        System.out.println("departureDateTime: " + departureDateTime);
        System.out.println("returnDateTime: " + returnDateTime);

        //http://localhost:8080/search/flights?departureAirport=SEA&arrivalAirport=SFO&departureDateTime=2020-01-01T00:00:00&returnDateTime=2020-01-01T01:00:00

        if (returnDateTime != null) {
            // Round-trip flights
            return flightRepository.findRoundTripFlights(departureAirport, arrivalAirport, departureDateTime, returnDateTime);
        } else {
            // One-way flights
            return flightRepository.findOneWayFlights(departureAirport, arrivalAirport, departureDateTime);
        }
    }
}