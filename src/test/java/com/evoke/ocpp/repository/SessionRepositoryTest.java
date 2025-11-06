package com.evoke.ocpp.repository;

import com.evoke.ocpp.entity.Session;
import com.evoke.ocpp.entity.Charger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SessionRepositoryTest {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private ChargerRepository chargerRepository;

    @Test
    void testSaveAndFindSession() {
        Charger charger = new Charger();
        charger.setSerialNumber("SN-54321");
        charger.setStatus("Charging");
        charger = chargerRepository.save(charger);

        Session session = new Session();
        session.setCharger(charger);
        session.setStartTime(LocalDateTime.now());
        session.setEndTime(LocalDateTime.now().plusHours(1));
        Session saved = sessionRepository.save(session);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getCharger().getSerialNumber()).isEqualTo("SN-54321");
    }
}

