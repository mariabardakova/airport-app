package org.airport.ui;

import org.airport.service.FlightService;
import org.airport.service.PassengerService;
import org.airport.service.TicketService;
import org.airport.ui.command.Command;
import org.airport.ui.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ConsoleApp {

    private final ConsoleHelper helper = new ConsoleHelper();
    private final Map<String, Command> commands = new HashMap<>();

    public ConsoleApp(FlightService flightService,
                      PassengerService passengerService,
                      TicketService ticketService) {
        commands.put("help", new HelpCommand());
        commands.put("flight add", new AddFlightCommand(flightService));
        commands.put("flight list", new ListFlightsCommand(flightService));
        commands.put("passenger add", new AddPassengerCommand(passengerService));
        commands.put("passenger list", new ListPassengersCommand(passengerService));
        commands.put("ticket sell", new SellTicketCommand(ticketService));
        commands.put("ticket list", new ListTicketsCommand(ticketService));
        commands.put("ticket cancel", new CancelTicketCommand(ticketService));
    }

    public void start() {
        System.out.println("Система управления авиарейсами");
        System.out.println("Введите 'help' для списка команд");

        while (true) {
            String input = helper.readLine("> ").trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split("\\s+");
            String first = parts[0].toLowerCase();

            if ("exit".equals(first) || "quit".equals(first)) {
                return;
            }

            if ("help".equals(first)) {
                commands.get("help").execute(new String[0]);
                System.out.println();
                continue;
            }

            if (parts.length < 2) {
                System.out.println("Неизвестная команда. Введите 'help'.");
                System.out.println();
                continue;
            }

            String key = first + " " + parts[1].toLowerCase();
            Command command = commands.get(key);

            if (command == null) {
                System.out.println("Неизвестная команда: " + key + ". Введите 'help'.");
                System.out.println();
                continue;
            }

            String[] args = new String[parts.length - 2];
            System.arraycopy(parts, 2, args, 0, args.length);

            try {
                command.execute(args);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            System.out.println();
        }
    }
}