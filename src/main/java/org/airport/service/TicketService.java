package org.airport.service;

import org.airport.entity.Flight;
import org.airport.entity.Passenger;
import org.airport.entity.Ticket;
import org.airport.repository.TicketRepository;

import java.util.List;

public class TicketService {

    private final TicketRepository ticketRepository;
    private final FlightService flightService;
    private final PassengerService passengerService;

    public TicketService(TicketRepository ticketRepository,
                         FlightService flightService,
                         PassengerService passengerService) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
        this.passengerService = passengerService;
    }

    public Ticket sellTicket(Long flightId, Long passengerId, String seatNumber) {
        Flight flight = flightService.getFlight(flightId);
        Passenger passenger = passengerService.getPassenger(passengerId);

        if (ticketRepository.existsByFlightIdAndSeatNumber(flightId, seatNumber)) {
            throw new IllegalArgumentException("Место " + seatNumber + " уже занято на рейсе " + flightId);
        }

        int soldTickets = ticketRepository.findByFlightId(flightId).size();
        if (soldTickets >= flight.getCapacity()) {
            throw new IllegalArgumentException("На рейсе " + flightId + " больше нет свободных мест");
        }

        Ticket ticket = new Ticket(flightId, passengerId, seatNumber);
        ticketRepository.save(ticket);
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Билет с id " + id + " не найден"));
    }

    public void cancelTicket(Long id) {
        getTicket(id);
        ticketRepository.deleteById(id);
    }

}