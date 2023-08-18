package com.example.demo.airports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportRepository airportRepository;

    @GetMapping
    public List<Airports> getAirports() {
        return airportRepository.findAll();
    }

    @GetMapping("/{id}")
    public Airports getAirportsById(@PathVariable Long id) {
        return airportRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Airports createAirport(@RequestBody Airports airports) {
        return airportRepository.save(airports);
    }

    @PutMapping("/{id}")
    public Airports updateAirport(@PathVariable Long id, @RequestBody Airports airports) {
        airports.setId(id);
        return airportRepository.save(airports);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportRepository.deleteById(id);
    }
}