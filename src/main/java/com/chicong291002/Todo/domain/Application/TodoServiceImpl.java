package com.chicong291002.Todo.domain.Application;

import com.chicong291002.Todo.domain.Abstract.TodoService;
import com.chicong291002.Todo.domain.dto.TodoDto;
import com.chicong291002.Todo.domain.entitiy.Todo;
import com.chicong291002.Todo.domain.repository.TodoRepository;
import com.chicong291002.Todo.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public void addTodo(TodoDto todoDto) {
        Todo newTodo = new Todo();
        newTodo.addTodo(todoDto);
        Todo todo = ConvertUtil.gI().toEntity(todoDto, Todo.class);
        todo = todoRepository.save(todo);
        ConvertUtil.gI().toDto(todo, TodoDto.class);
    }

    @Override
    public void removeTodo(Integer todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()
                -> new RuntimeException("Todo with given id doesn't exist"));
        todo.removeTodo();
        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Integer id, TodoDto todoDto) {
        Todo updateTodo = getTodo(id);
        updateTodo.updateTodo(todoDto);

        updateTodo = ConvertUtil.gI().toEntity(todoDto, Todo.class);
        todoRepository.save(updateTodo);
        ConvertUtil.gI().toDto(todoDto, TodoDto.class);
    }

    private Todo getTodo(Integer id) {
        return todoRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Order with given id doesn't exist"));
    }


//    @Override
//    public List<TodoDto> getAllTodos() {
//        List<Todo> todos = todoRepository.findAll();
//        return todos.stream().map(todo -> ConvertUtil.gI().toDto(todo, TodoDto.class)).collect(Collectors.toList());
//    }
//
//    @Override
//    public TodoDto getTodoById(Integer todoId) {
//        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
//        if (optionalTodo.isPresent()) {
//            Todo todo = optionalTodo.get();
//            return ConvertUtil.gI().toDto(todo, TodoDto.class);
//        } else {
//            return null; // or throw an exception
//        }
//    }
//
//    @Override
//    public TodoDto save(TodoDto todoDto) {
//        Todo todo = ConvertUtil.gI().toEntity(todoDto, Todo.class);
//        todo = todoRepository.save(todo);
//        return ConvertUtil.gI().toDto(todo, TodoDto.class);
//    }
//
//    @Override
//    public List<TodoDto> getAllTodoByUserId(Integer userId) {
//        return todoRepository.findAllByUserId(userId);
//    }
}
