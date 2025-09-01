package org.example.dao;

import org.example.model.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface PlanetDaoService {

    public void save(Planet planet);


    public Planet findById(String id) ;


    public void update(Planet planet);


    public void delete(Planet planet) ;

}
