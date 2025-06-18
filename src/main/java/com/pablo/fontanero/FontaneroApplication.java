package com.pablo.fontanero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@SpringBootApplication
@EnableMongoAuditing(dateTimeProviderRef = "dateTimeProvider")
public class FontaneroApplication {

	public static void main(String[] args) {
		System.setProperty("user.timezone", "Europe/Madrid");
		SpringApplication.run(FontaneroApplication.class, args);
	}


	@Bean
	public DateTimeProvider dateTimeProvider() {
		return () -> Optional.of(LocalDateTime.now(ZoneId.of("Europe/Madrid")));
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
