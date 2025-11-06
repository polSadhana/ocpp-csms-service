package com.evoke.ocpp.websocket;

import org.junit.jupiter.api.Test;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class OcppWebSocketHandlerTest {
    @Test
    void testHandleTextMessage() throws Exception {
        OcppWebSocketHandler handler = new OcppWebSocketHandler();
        WebSocketSession session = Mockito.mock(WebSocketSession.class);
        TextMessage message = new TextMessage("{\"test\":\"payload\"}");
        handler.handleTextMessage(session, message);
        // No exception means pass for now; extend with assertions as logic is added
    }
}

