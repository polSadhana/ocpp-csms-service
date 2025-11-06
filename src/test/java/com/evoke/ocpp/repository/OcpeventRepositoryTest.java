package com.evoke.ocpp.repository;

import com.evoke.ocpp.entity.Ocpevent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OcpeventRepositoryTest {
    @Autowired
    private OcpeventRepository ocpeventRepository;

    @Test
    void testSaveAndFindOcpevent() {
        Ocpevent event = new Ocpevent();
        event.setEventType("BootNotification");
        event.setPayload("{\"chargePointModel\":\"ModelX\"}");
        event.setReceivedAt(LocalDateTime.now());
        Ocpevent saved = ocpeventRepository.save(event);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getEventType()).isEqualTo("BootNotification");
    }
}

