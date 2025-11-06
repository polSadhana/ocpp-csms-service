package com.example.ocpp.service;

import eu.chargetime.ocpp.JSONServer;
import eu.chargetime.ocpp.features.basic.BootNotificationFeature;
import eu.chargetime.ocpp.features.basic.handlers.IServerBootNotificationRequestHandler;
import eu.chargetime.ocpp.model.basic.BootNotificationRequest;
import eu.chargetime.ocpp.model.basic.BootNotificationConfirmation;
import eu.chargetime.ocpp.model.basic.types.RegistrationStatusEnumType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OcppCsmsService {
    private static final Logger logger = LoggerFactory.getLogger(OcppCsmsService.class);
    private JSONServer ocppServer;

    public OcppCsmsService() {
        ocppServer = new JSONServer();
        ocppServer.addFeature(new BootNotificationFeature(new BootNotificationHandler()));
        logger.info("OCPP CSMS Server initialized.");
    }

    public JSONServer getOcppServer() {
        return ocppServer;
    }

    private static class BootNotificationHandler implements IServerBootNotificationRequestHandler {
        @Override
        public BootNotificationConfirmation handleBootNotificationRequest(java.util.UUID sessionId, BootNotificationRequest request) {
            BootNotificationConfirmation confirmation = new BootNotificationConfirmation();
            confirmation.setStatus(RegistrationStatusEnumType.Accepted);
            confirmation.setCurrentTime(java.time.ZonedDateTime.now());
            confirmation.setInterval(300);
            return confirmation;
        }
    }
}
