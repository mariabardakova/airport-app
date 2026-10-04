package org.airport.repository.inmemory;

import org.airport.entity.Ticket;
import org.airport.repository.TicketRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryTicketRepository implements TicketRepository {

    private final Map<Long, Ticket> storage = new HashMap<>();
    private long nextId = 1L;

    @Override
    public void save(Ticket ticket) {
        if (ticket.getId() == null) {
            ticket.setId(nextId++);
        }
        storage.put(ticket.getId(), ticket);
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public List<Ticket> findByFlightId(Long flightId) {
        if (flightId == null) {
            return List.of();
        }
        return storage.values().stream()
                .filter(t -> t.getFlightId().equals(flightId))
                .toList();
    }

    @Override
    public boolean existsByFlightIdAndSeatNumber(Long flightId, String seatNumber) {
        if (flightId == null || seatNumber == null) {
            return false;
        }
        String target = seatNumber.trim();
        return storage.values().stream()
                .anyMatch(t -> t.getFlightId().equals(flightId)
                        && t.getSeatNumber().equalsIgnoreCase(target));
    }
}