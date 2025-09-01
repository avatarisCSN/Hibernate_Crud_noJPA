package org.example.service;


import org.example.model.Ticket;

public interface TicketCrudService {

    public void saveTicket(Ticket ticket);

    public Ticket findTicketById(Long id);

    public void updateTicket(Ticket ticket);

    public void deleteTicket(Ticket ticket);
}
