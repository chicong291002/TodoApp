package com.chicong291002.Todo.presentation.http;

import com.chicong291002.Todo.domain.Abstract.TodoService;
import com.chicong291002.Todo.domain.dto.TodoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoRestController {
    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }
//
//    @GetMapping
//    public ResponseEntity<List<TodoDto>> getAllTodos() {
//        return ResponseEntity.ok(todoService.getAllTodos());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<TodoDto> getTodoById(@PathVariable Integer id) {
//        return ResponseEntity.ok(todoService.getTodoById(id));
//    }

    @PostMapping
    public void createTodo(@RequestBody TodoDto todoDto) {
        todoService.addTodo(todoDto);
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable Integer id, @RequestBody TodoDto todoDto) {
        todoService.updateTodo(id, todoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Integer id) {
        todoService.removeTodo(id);
    }
}