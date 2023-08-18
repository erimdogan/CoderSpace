package com.example.demo.airports;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airports, Long> {
}
