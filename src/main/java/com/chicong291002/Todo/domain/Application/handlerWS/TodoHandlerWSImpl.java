package com.chicong291002.Todo.domain.Application.handlerWS;

import com.chicong291002.Todo.domain.Abstract.TodoService;
import com.chicong291002.Todo.domain.Abstract.WS;
import com.chicong291002.Todo.domain.entitiy.RequestEntity;
import com.chicong291002.Todo.domain.dto.TodoDto;
import com.chicong291002.Todo.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Service
public class TodoHandlerWSImpl implements WS {
    @Autowired
    TodoService todoService;

    @Override
    public void handleWSRequest(WebSocketSession session, RequestEntity request) throws IOException {
        if (request.getObject().equals("todo")) {
            TodoDto todoDto = GsonUtil.gI().fromJson(GsonUtil.gI().toJson(request.getBody()), TodoDto.class);
            TodoDto responseTodo = null;
            switch (request.getOperation()) {
                case "add":
                    todoService.addTodo(todoDto);
                    break;
                case "remove":
                    todoService.removeTodo(todoDto.getTodoId());
                    break;
                case "update":
                    todoService.updateTodo(todoDto.getTodoId(),todoDto);
                    break;
            }
            // Gửi dữ liệu trở lại cho client
            session.sendMessage(new TextMessage(GsonUtil.gI().toJson(responseTodo)));}
    }
}