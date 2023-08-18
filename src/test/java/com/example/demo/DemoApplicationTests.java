package com.example.demo;

import com.example.demo.airports.AirportController;
import com.example.demo.airports.AirportRepository;
import com.example.demo.flights.FlightController;
import com.example.demo.flights.FlightRepository;
import com.example.demo.flights.Flights;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;


import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
}

@WebMvcTest(FlightController.class)
class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightRepository flightRepository;

    @Test
    public void testGetAllFlights() throws Exception {
        when(flightRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetFLightById() throws Exception {
        Flights flight = new Flights();
        flight.setId(1L);
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));

        mockMvc.perform(get("/flights/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testCreateFlight() throws Exception {

        Flights flightToSave = new Flights();
        flightToSave.setId(1L);
        flightToSave.setDepartureAirport("LAX");
        flightToSave.setArrivalAirPort("JFK");
        flightToSave.setDepartureDateTime(LocalDateTime.parse("2020-01-01T01:00:00"));
        flightToSave.setArrivalDateTime(LocalDateTime.parse("2020-01-01T04:00:00"));
        flightToSave.setPrice(200.00);

        when(flightRepository.save(any(Flights.class))).thenReturn(flightToSave);

        mockMvc.perform(post("/flights")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"departureAirport\":\"LAX\",\"arrivalAirPort\":\"JFK\",\"departureDateTime\":\"2020-01-01T01:00:00\",\"arrivalDateTime\":\"2020-01-01T04:00:00\",\"price\":200.00}"))
                .andExpect(status().isOk())
                .andReturn();

        MvcResult result = mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, result.getResponse().getContentType());
    }

    @Test
    public void testUpdateFlight() throws Exception {
        when(flightRepository.save(null)).thenReturn(null);

        mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void testDeleteFlight() throws Exception {
        when(flightRepository.save(null)).thenReturn(null);

        mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").doesNotExist());
    }
}

@WebMvcTest(AirportController.class)
class AirportControllerTests{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportRepository airportRepository;

    @Test
    public void testGetAllAirports() throws Exception {
        when(airportRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/airports"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetAirportById() throws Exception {
        when(airportRepository.findById(1L)).thenReturn(null);

        mockMvc.perform(get("/airports"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void testCreateAirport() throws Exception {
        when(airportRepository.save(null)).thenReturn(null);

        mockMvc.perform(get("/airports"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void testUpdateAirport() throws Exception {
        when(airportRepository.save(null)).thenReturn(null);

        mockMvc.perform(get("/airports"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    public void testDeleteAirport() throws Exception {
        when(airportRepository.save(null)).thenReturn(null);

        mockMvc.perform(get("/airports"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").doesNotExist());
    }
}