package com.evoke.ocpp.repository;

import com.example.ocpp.entity.Transaction;
import com.evoke.ocpp.entity.Session;
import com.evoke.ocpp.entity.Charger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TransactionRepositoryTest {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private ChargerRepository chargerRepository;

    @Test
    void testSaveAndFindTransaction() {
        Charger charger = new Charger();
        charger.setSerialNumber("SN-99999");
        charger.setStatus("Charging");
        charger = chargerRepository.save(charger);

        Session session = new Session();
        session.setCharger(charger);
        session.setStartTime(LocalDateTime.now());
        session.setEndTime(LocalDateTime.now().plusHours(2));
        session = sessionRepository.save(session);

        Transaction transaction = new Transaction();
        transaction.setSession(session);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setAmount(42.0);
        Transaction saved = transactionRepository.save(transaction);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getSession().getId()).isEqualTo(session.getId());
        assertThat(saved.getAmount()).isEqualTo(42.0);
    }
}

