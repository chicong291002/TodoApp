package com.chicong291002.Todo.presentation.websocket;

import com.chicong291002.Todo.domain.Abstract.TodoService;
import com.chicong291002.Todo.domain.dto.TodoDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TodoWebSocketController {
    private final TodoService todoService;

    public TodoWebSocketController(TodoService todoService) {
        this.todoService = todoService;
    }

    @MessageMapping("/todo.add")
    @SendTo("/topic/todos")
    public void addTodo(TodoDto todoDto) {
        todoService.addTodo(todoDto);
    }

    @MessageMapping("/todo.remove")
    @SendTo("/topic/todos")
    public void removeTodo(Integer todoId) {
        todoService.removeTodo(todoId);
    }

//    @MessageMapping("/todo.getAllByUserId")
//    @SendTo("/topic/todos")
//    public List<TodoDto> getAllTodoByUserId(Integer userId) {
//        return todoService.getAllTodoByUserId(userId);
//    }
//
//    @MessageMapping("/todo.getById")
//    @SendTo("/topic/todos")
//    public TodoDto getTodoById(Integer todoId) {
//        return todoService.getTodoById(todoId);
//    }
//
//    @MessageMapping("/todo.update")
//    @SendTo("/topic/todos")
//    public TodoDto updateTodo(Integer id, TodoDto todoDto) {
//        return todoService.updateTodo(id, todoDto);
//    }
}