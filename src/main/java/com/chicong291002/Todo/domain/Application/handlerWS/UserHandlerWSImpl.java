package com.chicong291002.Todo.domain.Application.handlerWS;

import com.chicong291002.Todo.domain.Abstract.UserService;
import com.chicong291002.Todo.domain.Abstract.WS;
import com.chicong291002.Todo.domain.entitiy.RequestEntity;
import com.chicong291002.Todo.domain.dto.UserDto;
import com.chicong291002.Todo.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Service
public class UserHandlerWSImpl implements WS {
    @Autowired
    UserService userService;
    @Override
    public void handleWSRequest(WebSocketSession session, RequestEntity request) throws IOException {
        if (request.getObject().equals("user")) {
            UserDto userDto = GsonUtil.gI().fromJson(GsonUtil.gI().toJson(request.getBody()), UserDto.class);
            UserDto responseTodo = null;
            switch (request.getOperation()) {
                case "add":
                    responseTodo = userService.addUser(userDto);
                    break;
                case "remove":
                    responseTodo = userService.removeUser(userDto.getUserId());
                    break;
                case "update":
                    responseTodo = userService.updateUser(userDto);
                    break;
                case "getall":
                    responseTodo = userService.getAllUser();
            }

            // Gửi dữ liệu trở lại cho client
            if (responseTodo != null) {
                String responseTodoJson = GsonUtil.gI().toJson(responseTodo);
                session.sendMessage(new TextMessage(responseTodoJson));
            }
        }
    }
}
