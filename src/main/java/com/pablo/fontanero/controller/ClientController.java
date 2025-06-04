package com.pablo.fontanero.controller;

import com.pablo.fontanero.domain.Clients;
import com.pablo.fontanero.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Log4j
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Clients createRequest(@RequestBody Clients clients) {
        System.out.println("Received client data: " + clients);
        return clientService.saveClient(clients);
    }


}
