package org.example.service;

import org.example.model.Client;

public interface ClientCrudService {
    public void saveClient(Client client);

    public Client findClientById(Long id);

    public void updateClient(Client client);

    public void deleteClient(Client client);
}
