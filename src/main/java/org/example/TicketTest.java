package org.example;

import org.example.dao.*;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.ClientCrudServiceImpl;
import org.example.service.PlanetCrudServiceImpl;
import org.example.service.TicketCrudServiceImpl;

import java.util.Objects;

public class TicketTest {
    public static void main(String[] args) {
        ClientDaoService clientDao = new ClientDaoImpl();
        ClientCrudServiceImpl clientCrudService = new ClientCrudServiceImpl(clientDao);

        PlanetDaoService planetDao = new PlanetDaoImpl();
        PlanetCrudServiceImpl planetCrudService = new PlanetCrudServiceImpl(planetDao);

        TicketDaoService ticketDao = new TicketDaoImpl();
        TicketCrudServiceImpl ticketCrudService = new TicketCrudServiceImpl(ticketDao, planetDao, clientDao);

        Client client = clientCrudService.findClientById(5L);
        Planet fromPlanet = planetCrudService.findPlanetById("MERC");
        Planet outPlanet = planetCrudService.findPlanetById("EARTH");

        Planet invalidPlanet = planetCrudService.findPlanetById("INVALID"); // invalid

        Ticket emptyTicket = new Ticket();
        Ticket unSavedTicket = new Ticket(client, fromPlanet, outPlanet);
        Ticket fromBdTicket = ticketCrudService.findTicketById(5L);
        System.out.println(fromBdTicket);
        System.out.println(unSavedTicket);

        Ticket editedTicket = ticketCrudService.findTicketById(6L);

        editedTicket.setFromPlanet(fromPlanet);
        editedTicket.setToPlanet(outPlanet);
        editedTicket.setClient(client);
        System.out.println(editedTicket);

        fromBdTicket.setFromPlanet(invalidPlanet);



        ticketCrudService.updateTicket(fromBdTicket); // обновляем  НЕ валидный билет - ОШИБКА
        ticketCrudService.updateTicket(editedTicket); // обновляем валидный билет

        ticketCrudService.saveTicket(unSavedTicket); //создаем валидный билет
       ticketCrudService.saveTicket(emptyTicket); //создаем пустой билет - ОШИБКА


    }
}
