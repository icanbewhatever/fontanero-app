package com.pablo.fontanero.service;

import com.pablo.fontanero.domain.Clients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ClientServiceTest {

    @Mock
    ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("create request by customer")
    void register() {
        // given
        Clients testClient = new Clients();
        testClient.setName("홍길동");
        testClient.setPhone("01012345678");
        testClient.setMessage("예약 문의");
        testClient.setAvailableTime(LocalDateTime.of(2025, 8, 6, 14, 0));
        testClient.setCreateDate(LocalDateTime.now());

        //when
        clientService.saveClient(testClient);

        //then
        assertThat(testClient).isNotNull();
        assertThat(testClient.getName()).isEqualTo("홍길동");
        assertThat(testClient.getPhone()).isEqualTo("01012345678");

    }


}