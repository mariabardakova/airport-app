package org.airport;

import org.airport.repository.FlightRepository;
import org.airport.repository.PassengerRepository;
import org.airport.repository.TicketRepository;
import org.airport.repository.inmemory.InMemoryFlightRepository;
import org.airport.repository.inmemory.InMemoryPassengerRepository;
import org.airport.repository.inmemory.InMemoryTicketRepository;
import org.airport.service.FlightService;
import org.airport.service.PassengerService;
import org.airport.service.TicketService;
import org.airport.ui.ConsoleApp;

public class Main {
    public static void main(String[] args) {
        FlightRepository flightRepository = new InMemoryFlightRepository();
        PassengerRepository passengerRepository = new InMemoryPassengerRepository();
        TicketRepository ticketRepository = new InMemoryTicketRepository();

        FlightService flightService = new FlightService(flightRepository);
        PassengerService passengerService = new PassengerService(passengerRepository);
        TicketService ticketService = new TicketService(
                ticketRepository, flightService, passengerService);

        ConsoleApp app = new ConsoleApp(flightService, passengerService, ticketService);
        app.start();
    }
}