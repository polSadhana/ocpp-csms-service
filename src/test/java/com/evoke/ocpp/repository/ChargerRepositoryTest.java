package com.evoke.ocpp.repository;

import com.evoke.ocpp.entity.Charger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ChargerRepositoryTest {
    @Autowired
    private ChargerRepository chargerRepository;

    @Test
    void testSaveAndFindCharger() {
        Charger charger = new Charger();
        charger.setSerialNumber("SN-12345");
        charger.setStatus("Available");
        Charger saved = chargerRepository.save(charger);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getSerialNumber()).isEqualTo("SN-12345");
        assertThat(saved.getStatus()).isEqualTo("Available");
    }
}

