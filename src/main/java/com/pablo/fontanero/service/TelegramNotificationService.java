package com.pablo.fontanero.service;

import com.pablo.fontanero.domain.Clients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class TelegramNotificationService {
    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.chat.id}")
    private String chatId;

    private final RestTemplate restTemplate;

    public TelegramNotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendNotification(Clients client) {
        String message = String.format(
                "<b>Nueva solicitud de formulario</b>:\n" +
                "<b>Nombre</b>: %s\n" +
                "<b>Teléfono</b>: %s\n" +
                "<b>Mensaje</b>: %s\n" +
                "<b>Hora disponible</b>: %s\n" +
                "<b>Hora de creación</b>: %s",
                client.getName(),
                client.getPhone(),
                client.getMessage(),
                client.getAvailableTime(),
                client.getCreateDate()
        );
        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
        String url = String.format(
                "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s",
                botToken, chatId, encodedMessage
        );
        try {
            restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            System.err.println("Telegram notification failed: " + e.getMessage());
        }
    }
}
