package org.example.service;

import org.example.dao.ClientDaoService;
import org.example.model.Client;

public class ClientCrudServiceImpl implements ClientCrudService {
    private ClientDaoService clientDao;

    public ClientCrudServiceImpl (ClientDaoService clientDao) {
        this.clientDao = clientDao;
    }

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public Client findClientById(Long id) {
        return clientDao.findById(id);
    }

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
