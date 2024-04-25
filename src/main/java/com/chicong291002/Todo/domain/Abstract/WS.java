package com.chicong291002.Todo.domain.Abstract;

import com.chicong291002.Todo.domain.entitiy.RequestEntity;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public interface WS {
    void handleWSRequest(WebSocketSession session, RequestEntity request) throws IOException;
}
