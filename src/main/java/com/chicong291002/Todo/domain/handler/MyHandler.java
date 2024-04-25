package com.chicong291002.Todo.domain.handler;

import com.chicong291002.Todo.domain.Abstract.WS;
import com.chicong291002.Todo.domain.entitiy.RequestEntity;
import com.chicong291002.Todo.util.GsonUtil;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MyHandler extends TextWebSocketHandler {
    @Autowired
    List<WS> wsHandlers;

    private ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try {
            System.out.println("Test message " + message.getPayload());
            RequestEntity wsEntity = GsonUtil.gI().fromJson(message.getPayload(), RequestEntity.class);
            for (WS ws: wsHandlers){
                ws.handleWSRequest(session,wsEntity);
            }
            log.info("Test message {}", message.toString());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            session.sendMessage(new TextMessage("Invalid JSON format"));
        } catch (Exception e) {
            e.printStackTrace();
            session.sendMessage(new TextMessage("An error occurred: " + e.getMessage()));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        sessions.remove(session.getId());
    }
}

