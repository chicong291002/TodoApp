package com.chicong291002.Todo.domain.Abstract;

import com.chicong291002.Todo.domain.entitiy.ShareTodo;

public interface ShareService {
    void save(ShareTodo share);
    ShareTodo getTodoById(Integer id);
    void deleteByTodoId(Integer todoId);
    boolean existsByUserIdAndTodoId(Integer userId, Integer todoId);
}
