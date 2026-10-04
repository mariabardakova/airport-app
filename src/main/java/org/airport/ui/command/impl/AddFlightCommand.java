package org.airport.ui.command.impl;

import org.airport.entity.Flight;
import org.airport.service.FlightService;
import org.airport.ui.command.Command;

public class AddFlightCommand implements Command {
    private final FlightService flightService;

    public AddFlightCommand(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 5) {
            System.out.println("flight add <number> <origin> <destination> <departure> <capacity>");
            return;
        }
        Flight f = flightService.addFlight(
                args[0], args[1], args[2], args[3], Integer.parseInt(args[4]));
        System.out.println("Создан рейс: " + f);
    }
}