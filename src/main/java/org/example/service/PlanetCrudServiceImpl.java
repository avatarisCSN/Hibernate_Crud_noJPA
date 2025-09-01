package org.example.service;

import org.example.dao.PlanetDaoImpl;
import org.example.dao.PlanetDaoService;
import org.example.model.Planet;

public class PlanetCrudServiceImpl implements PlanetCrudService {
    private PlanetDaoService planetDao;

    public PlanetCrudServiceImpl (PlanetDaoService planetDao) {
        this.planetDao =  planetDao;
    }
    public boolean validatePlanet (String id) {
        return id.matches("[A-Z0-9]+");
    }

    public void savePlanet(Planet planet) {
        if (validatePlanet(planet.getId())) { planetDao.save(planet); }
    }

    public Planet findPlanetById(String id) {
        if (validatePlanet(id)) { return planetDao.findById(id); }
        else return null;
    }

    public void updatePlanet(Planet planet) {
        if (validatePlanet(planet.getId())) { planetDao.update(planet); }
    }

    public void deletePlanet(Planet planet) {
        if (validatePlanet(planet.getId())) { planetDao.delete(planet); }
    }
}
