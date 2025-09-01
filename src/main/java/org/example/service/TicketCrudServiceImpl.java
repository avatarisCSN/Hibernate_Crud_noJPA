package org.example.service;

import org.example.dao.ClientDaoService;
import org.example.dao.PlanetDaoService;
import org.example.dao.TicketDaoService;

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

    public boolean validateTicket (Ticket ticket) {
        if (ticket.getClient() == null || ticket.getToPlanet() == null || ticket.getFromPlanet() == null) {
            return false;
        } else if
              ( clientDao.findById(ticket.getClient().getId()).equals(ticket.getClient()) &&
                planetDao.findById(ticket.getFromPlanet().getId()).equals(ticket.getFromPlanet()) &&
                planetDao.findById(ticket.getToPlanet().getId()).equals(ticket.getToPlanet())  ) {
         return true;
        } else  {
            return false;
        }
    };

    public void saveTicket(Ticket ticket) {
        if (validateTicket(ticket)) {
            ticketDao.save(ticket);
        }
    };


    public Ticket findTicketById(Long id) {
        return ticketDao.findById(id);
    }

    public void updateTicket(Ticket ticket) {
        if (validateTicket(ticket)) {
            ticketDao.update(ticket);
        }
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
