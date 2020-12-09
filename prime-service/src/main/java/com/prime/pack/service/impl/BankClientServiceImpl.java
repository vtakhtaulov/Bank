package com.prime.pack.service.impl;

import com.prime.pack.domain.Client;
import com.prime.pack.repository.ClientRepository;
import com.prime.pack.service.BankClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankClientServiceImpl implements BankClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client updateClientInfo(Long id, Client client) {
        client.setId(id);
        return clientRepository.save(client);
    }

    @Override
    public boolean addClient(Client client) {
        try{
            clientRepository.save(client);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
