package org.example.service;

import org.example.dao.ClientDaoService;
import org.example.dao.PlanetDaoService;
import org.example.dao.TicketDaoService;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;

public class TicketCrudServiceImpl {
    private TicketDaoService ticketDao;
    private PlanetDaoService planetDao;
    private ClientDaoService clientDao;

    public TicketCrudServiceImpl(TicketDaoService ticketDao, PlanetDaoService planetDao, ClientDaoService clientDao) {
        this.ticketDao = ticketDao;
        this.planetDao = planetDao;
        this.clientDao = clientDao;
    }

    public void validateTicket (Ticket ticket) {
        if (clientDao.findById(ticket.getClient().getId()) == null) {
            throw new IllegalArgumentException("Client with id does not exist");
        }

        if (planetDao.findById(ticket.getFromPlanet().getId()) == null) {
            throw new IllegalArgumentException("From planet not exist");
        }

        if (planetDao.findById(ticket.getToPlanet().getId()) == null) {
            throw new IllegalArgumentException("To planet not exist");
        }

    };

    public void saveTicket(Ticket ticket) {
        validateTicket(ticket);
            ticketDao.save(ticket);
            System.out.println("TICKET IS SAVED");

    };


    public Ticket findTicketById(Long id) {
        return ticketDao.findById(id);
    }

    public void updateTicket(Ticket ticket) {
        validateTicket(ticket);
            System.out.println("TICKET IS UPDATED");
            ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
