package org.airport.ui.command.impl;

import org.airport.entity.Passenger;
import org.airport.service.PassengerService;
import org.airport.ui.command.Command;

public class AddPassengerCommand implements Command {
    private final PassengerService passengerService;

    public AddPassengerCommand(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("passenger add <fullName> <passport>");
            return;
        }
        Passenger p = passengerService.addPassenger(args[0], args[1]);
        System.out.println("Создан пассажир: " + p);
    }
}