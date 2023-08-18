package com.example.demo.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Flights> getFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/{id}")
    public Flights getFlightById(@PathVariable Long id) {
        return flightRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Flights createFlight(@RequestBody Flights flight) {
        return flightRepository.save(flight);
    }

    @PutMapping("/{id}")
    public Flights updateFlight(@PathVariable Long id, @RequestBody Flights flight) {
        flight.setId(id);
        return flightRepository.save(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
    }
}