package com.evoke.ocpp.repository;

import com.evoke.ocpp.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {}
