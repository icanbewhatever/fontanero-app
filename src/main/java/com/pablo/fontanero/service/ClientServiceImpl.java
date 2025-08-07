package com.pablo.fontanero.service;

import com.pablo.fontanero.domain.Clients;
import com.pablo.fontanero.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Clients saveClient(Clients clients) {
        return clientRepository.save(clients);
    }
}
