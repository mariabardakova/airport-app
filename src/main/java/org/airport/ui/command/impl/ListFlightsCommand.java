package org.airport.ui.command.impl;

import org.airport.entity.Flight;
import org.airport.service.FlightService;
import org.airport.ui.command.Command;

import java.util.List;

public class ListFlightsCommand implements Command {
    private final FlightService flightService;

    public ListFlightsCommand(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public void execute(String[] args) {
        List<Flight> flights = flightService.getAllFlights();
        if (flights.isEmpty()) { System.out.println("Рейсов нет."); return; }
        for (Flight f : flights) System.out.println(f);
    }
}