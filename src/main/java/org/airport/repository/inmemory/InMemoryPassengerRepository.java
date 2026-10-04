package org.airport.repository.inmemory;

import org.airport.entity.Passenger;
import org.airport.repository.PassengerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPassengerRepository implements PassengerRepository {

    private final Map<Long, Passenger> storage = new HashMap<>();
    private long nextId = 1L;

    @Override
    public void save(Passenger passenger) {
        if (passenger.getId() == null) {
            passenger.setId(nextId++);
        }
        storage.put(passenger.getId(), passenger);
    }

    @Override
    public Optional<Passenger> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Passenger> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public Optional<Passenger> findByPassportNumber(String passportNumber) {
        if (passportNumber == null) {
            return Optional.empty();
        }
        return storage.values().stream()
                .filter(p -> p.getPassportNumber().equalsIgnoreCase(passportNumber.trim()))
                .findFirst();
    }
}