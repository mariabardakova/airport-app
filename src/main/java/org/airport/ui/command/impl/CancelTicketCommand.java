package org.airport.ui.command.impl;

import org.airport.service.TicketService;
import org.airport.ui.command.Command;

public class CancelTicketCommand implements Command {
    private final TicketService ticketService;

    public CancelTicketCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("ticket cancel <id>");
            return;
        }
        ticketService.cancelTicket(Long.parseLong(args[0]));
        System.out.println("Билет отменён.");
    }
}