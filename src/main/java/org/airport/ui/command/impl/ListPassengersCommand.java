package org.airport.ui.command.impl;

import org.airport.entity.Passenger;
import org.airport.service.PassengerService;
import org.airport.ui.command.Command;

import java.util.List;

public class ListPassengersCommand implements Command {
    private final PassengerService passengerService;

    public ListPassengersCommand(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Override
    public void execute(String[] args) {
        List<Passenger> passengers = passengerService.getAllPassengers();
        if (passengers.isEmpty()) { System.out.println("Пассажиров нет."); return; }
        for (Passenger p : passengers) System.out.println(p);
    }
}