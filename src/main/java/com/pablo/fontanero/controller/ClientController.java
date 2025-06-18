package com.pablo.fontanero.controller;

import com.pablo.fontanero.domain.Clients;
import com.pablo.fontanero.service.ClientService;
import com.pablo.fontanero.service.TelegramNotificationService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Log4j
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private final TelegramNotificationService telegramNotificationService;

    @Autowired
    public ClientController(ClientService clientService, TelegramNotificationService telegramNotificationService) {
        this.clientService = clientService;
        this.telegramNotificationService = telegramNotificationService;
    }

    @PostMapping
    public ResponseEntity<Clients> createRequest(@RequestBody Clients clients) {
        System.out.println("Received client data: " + clients);
        Clients savedClient = clientService.saveClient(clients);
        telegramNotificationService.sendNotification(savedClient);
        return ResponseEntity.ok(savedClient);
    }


}
