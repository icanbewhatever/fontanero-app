package com.pablo.fontanero.repository;

import com.pablo.fontanero.domain.Clients;
import com.pablo.fontanero.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClientRepositoryTest {

    @Mock
    ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("가짜 save와 findById로 동작 테스트")
    void save() {
        Clients client = new Clients();
        client.setId("test123"); // 직접 ID 설정
        client.setName("테스트 유저");
        client.setPhone("01012345678");
        client.setMessage("테스트 메시지");
        client.setAvailableTime(LocalDateTime.of(2025, 8, 6, 14, 0));
        client.setCreateDate(LocalDateTime.now());

        // when - 가짜 동작 지정
        when(clientRepository.save(any(Clients.class))).thenReturn(client);
        when(clientRepository.findById("test123")).thenReturn(Optional.of(client));

        // then - 결과 확인
        Clients saved = clientRepository.save(client);
        Optional<Clients> found = clientRepository.findById("test123");

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("테스트 유저");
    }
}