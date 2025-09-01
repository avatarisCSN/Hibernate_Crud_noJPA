package org.example.dao;


import org.example.model.Ticket;

public interface TicketDaoService {
    public void save(Ticket ticket);


    public Ticket findById(Long id) ;


    public void update(Ticket ticket);


    public void delete(Ticket ticket) ;
}
