package org.airport.repository;

import org.airport.entity.Ticket;

import java.util.List;

public interface TicketRepository extends MyRepository<Ticket> {

    List<Ticket> findByFlightId(Long flightId);
    boolean existsByFlightIdAndSeatNumber(Long flightId, String seatNumber);
}