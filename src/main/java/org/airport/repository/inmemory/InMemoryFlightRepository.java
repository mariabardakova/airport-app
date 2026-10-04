package org.airport.repository.inmemory;

import org.airport.entity.Flight;
import org.airport.repository.FlightRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryFlightRepository implements FlightRepository {

    private final Map<Long, Flight> storage = new HashMap<>();
    private long nextId = 1L;

    @Override
    public void save(Flight flight) {
        if (flight.getId() == null) {
            flight.setId(nextId++);
        }
        storage.put(flight.getId(), flight);
    }

    @Override
    public Optional<Flight> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Flight> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public Optional<Flight> findByFlightNumber(String flightNumber) {
        if (flightNumber == null) {
            return Optional.empty();
        }
        return storage.values().stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber.trim()))
                .findFirst();
    }
}