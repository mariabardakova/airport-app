package org.airport.ui.command.impl;

import org.airport.entity.Ticket;
import org.airport.service.TicketService;
import org.airport.ui.command.Command;

import java.util.List;

public class ListTicketsCommand implements Command {
    private final TicketService ticketService;

    public ListTicketsCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void execute(String[] args) {
        List<Ticket> tickets = ticketService.getAllTickets();
        if (tickets.isEmpty()) { System.out.println("Билетов нет."); return; }
        for (Ticket t : tickets) System.out.println(t);
    }
}