package com.evoke.ocpp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Configures the WebSocket endpoint for OCPP 2.1 communication.
 */
@Configuration
@EnableWebSocket
public class OcppWebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new com.evoke.ocpp.websocket.OcppWebSocketHandler(), "/ocpp/csms")
                .setAllowedOrigins("*");
    }
}

