package com.prime.pack.service;

import com.prime.pack.domain.Client;

import java.util.List;

public interface BankClientService {

    List<Client> getClients();

    Client getClient(Long id);

    Client updateClientInfo(Long id, Client client);

    boolean addClient(Client client);
}
