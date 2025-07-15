package com.pablo.fontanero.service;

import com.pablo.fontanero.domain.Clients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

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
        // 타임스탬프 포맷팅
        String formattedCreateDate = formatTimestamp(client.getCreateDate());
        String formattedAvailableTime = formatTimestamp(client.getAvailableTime());

        // 메시지 포맷팅 (Markdown 형식)
        String message = String.format(
                "*Nueva solicitud*\n" +
                "*Nombre*: %s\n" +
                "*Teléfono*: %s\n" +
                "*Mensaje*: %s\n" +
                "*Hora disponible*: %s\n" +
                "*Hora de creación*: %s",
                client.getName(),
                client.getPhone(),
                client.getMessage(),
                formattedAvailableTime != null ? formattedAvailableTime : "--",
                formattedCreateDate
        );

        try {
            // 디버깅: 전송 전 메시지 확인
            System.out.println("Sending message: " + message);

            String url = String.format("https://api.telegram.org/bot%s/sendMessage", botToken);

            // 파라미터 구성
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("chat_id", chatId);
            params.add("text", message);
            params.add("parse_mode", "Markdown");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            System.out.println("Telegram API response: " + response.getBody());
        } catch (Exception e) {
            System.err.println("Telegram notification failed: " + e.getMessage());
        }
    }

    private String formatTimestamp(LocalDateTime timestamp) {
        if (timestamp == null) {
            return "--";
        }
        try {
            // Europe/Madrid 타임존으로 포맷팅, 스페인어 AM/PM 대체
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")
                    .withZone(ZoneId.of("Europe/Madrid"));
            String time = timestamp.atZone(ZoneId.of("Europe/Madrid")).format(formatter);
            int hour = timestamp.getHour();
            String period = (hour >= 12) ? "por la tarde" : "por la mañana";
            return time + " " + period;
        } catch (Exception e) {
            System.err.println("Timestamp formatting failed for '" + timestamp + "': " + e.getMessage());
            return timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME); // 오류 시 ISO 형식 반환
        }
    }

}
