package org.airport.ui.command.impl;

import org.airport.entity.Ticket;
import org.airport.service.TicketService;
import org.airport.ui.command.Command;

public class SellTicketCommand implements Command {
    private final TicketService ticketService;

    public SellTicketCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 3) {
            System.out.println("ticket sell <flightId> <passengerId> <seat>");
            return;
        }
        Ticket t = ticketService.sellTicket(
                Long.parseLong(args[0]), Long.parseLong(args[1]), args[2]);
        System.out.println("Продан билет: " + t);
    }
}