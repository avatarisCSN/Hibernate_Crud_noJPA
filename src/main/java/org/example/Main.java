package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.dao.ClientDaoImpl;
import org.example.dao.ClientDaoService;
import org.example.dao.PlanetDaoImpl;
import org.example.dao.PlanetDaoService;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.service.ClientCrudServiceImpl;
import org.example.service.PlanetCrudServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();


        Planet planet = new Planet("Al", "abc123");
        Planet planet2 = new Planet("EARTH4", "better earth");
        Planet planet3 = new Planet("VENUS3", "VEnerina muholovka");



        List<Planet> planets = List.of(planet, planet2, planet3);
        Set<ConstraintViolation<Planet>> allViolations = new HashSet<>();

        for (Planet p : planets) {
            allViolations.addAll(validator.validate(p));
        }

        allViolations.forEach(v ->
                System.out.println(v.getPropertyPath() + ": " + v.getMessage())
        );


        PlanetDaoService planetDao = new PlanetDaoImpl();
        PlanetCrudServiceImpl planetCrudService = new PlanetCrudServiceImpl(planetDao);

        planetCrudService.savePlanet(planet2);
        System.out.println(planetCrudService.findPlanetById("EARTH"));

        Planet existingPlanet = planetCrudService.findPlanetById(planet2.getId());
        existingPlanet.setName("Earth updated");
        planetCrudService.updatePlanet(existingPlanet);

        planetCrudService.deletePlanet(planet2);


        ClientDaoService clientDao = new ClientDaoImpl();
        ClientCrudServiceImpl clientCrudService = new ClientCrudServiceImpl(clientDao);

        Client client = new Client( "Alice");
        clientCrudService.saveClient(client);
        System.out.println(clientCrudService.findClientById(1L));

        Client existingClient2 = clientCrudService.findClientById(client.getId());
        existingClient2.setName("Alice Updated");
        clientCrudService.updateClient(existingClient2);

        clientCrudService.deleteClient(client);







    }
}