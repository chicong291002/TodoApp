package com.chicong291002.Todo.domain.Abstract;

import com.chicong291002.Todo.domain.dto.TodoDto;

import java.util.List;

public interface TodoService {
    void addTodo(TodoDto todo);
    void removeTodo(Integer todoId);
    void updateTodo(Integer id,TodoDto todo);
//    List<TodoDto> getAllTodos();
//    TodoDto getTodoById(Integer todoId);
//    TodoDto  save(TodoDto todoDto);
//    List<TodoDto> getAllTodoByUserId(Integer userId);
}
