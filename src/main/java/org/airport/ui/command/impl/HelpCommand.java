package org.airport.ui.command.impl;

import org.airport.ui.command.Command;

public class HelpCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Команды:");
        System.out.println("  help");
        System.out.println("  exit");
        System.out.println("  flight add <number> <origin> <destination> <departure> <capacity>");
        System.out.println("  flight list");
        System.out.println("  passenger add <fullName> <passport>");
        System.out.println("  passenger list");
        System.out.println("  ticket sell <flightId> <passengerId> <seat>");
        System.out.println("  ticket list");
        System.out.println("  ticket cancel <id>");
    }
}