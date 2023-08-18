package com.example.demo.airports;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}