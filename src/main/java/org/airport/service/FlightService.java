package org.airport.service;

import org.airport.entity.Flight;
import org.airport.repository.FlightRepository;

import java.util.List;

public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight addFlight(String flightNumber, String origin, String destination,
                            String departureTime, int capacity) {
        if (flightRepository.findByFlightNumber(flightNumber).isPresent()) {
            throw new IllegalArgumentException("Рейс с номером " + flightNumber + " уже существует");
        }
        Flight flight = new Flight(flightNumber, origin, destination, departureTime, capacity);
        flightRepository.save(flight);
        return flight;
    }

    public Flight getFlight(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Рейс с id " + id + " не найден"));
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}