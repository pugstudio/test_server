package com.example.test_server.web_socket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.lang.reflect.Method;

@Slf4j
public class MyWebSocketHandler extends TextWebSocketHandler {
    static ObjectMapper objectMapper = new ObjectMapper();
    final WebSocketService webSocketService;


    public MyWebSocketHandler(WebSocketService webSocketService) {
        this.webSocketService = webSocketService;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("PAYLOAD : {}", payload);

        JsonNode messageJson = objectMapper.readTree(payload);
        String uri = messageJson.get(0).asText();

        // 서비스 ID 및 메서드 경로 추출
//        String[] uriParts = uri.split("://");
//        String serviceId = uriParts[0];
//        String methodPath = uriParts[1];


        Pair<Object, Method> method = webSocketService.getMethodForPath("/v1/user/all");
        if (method != null) {
            method.getValue().invoke(method.getKey());
        }

        JsonNode header = messageJson.get(1);
        JsonNode body = messageJson.get(2);
        ((ObjectNode) body).removeAll();
        ((ObjectNode) body).put("content", "hello");

        session.sendMessage(new TextMessage(messageJson.toString()));
    }
}
