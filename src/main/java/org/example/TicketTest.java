package org.example;

import org.example.dao.*;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.ClientCrudServiceImpl;
import org.example.service.PlanetCrudServiceImpl;
import org.example.service.TicketCrudServiceImpl;

public class TicketTest {
    public static void main(String[] args) {
        ClientDaoService clientDao = new ClientDaoImpl();
        ClientCrudServiceImpl clientCrudService = new ClientCrudServiceImpl(clientDao);

        PlanetDaoService planetDao = new PlanetDaoImpl();
        PlanetCrudServiceImpl planetCrudService = new PlanetCrudServiceImpl(planetDao);

        TicketDaoService ticketDao = new TicketDaoImpl();
        TicketCrudServiceImpl ticketCrudService = new TicketCrudServiceImpl(ticketDao, planetDao, clientDao);

        Client client = clientCrudService.findClientById(5L);
        Planet fromPlanet = planetCrudService.findPlanetById("EARTH");
        Planet outPlanet = planetCrudService.findPlanetById("JUP");

        Ticket emptyTicket = new Ticket();
        Ticket realTicket = new Ticket(client, fromPlanet, outPlanet);

        ticketCrudService.saveTicket(realTicket); // создаем нормальный билет
        ticketCrudService.saveTicket(emptyTicket); //создаем сломанный билет





    }
}
