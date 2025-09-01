package org.example.service;

import org.example.model.Planet;

public interface PlanetCrudService {
    public void savePlanet(Planet planet);

    public Planet findPlanetById(String id) ;

    public void updatePlanet(Planet planet) ;

    public void deletePlanet(Planet planet) ;
}
