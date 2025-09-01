package org.example.dao;

import org.example.model.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public interface ClientDaoService {


    // Create
    public void save(Client client) ;

    // Read
    public Client findById(Long id) ;


    // Update
    public void update(Client client);

    // Delete
    public void delete(Client client);
}

