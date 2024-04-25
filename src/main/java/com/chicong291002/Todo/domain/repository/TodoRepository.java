package com.chicong291002.Todo.domain.repository;

import com.chicong291002.Todo.domain.entitiy.Todo;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository {
    Optional<Todo> findByUserId(Integer userId);
    List<Todo> findAllByUserId(Integer userId);

    Todo save(Todo todo);

    Optional<Todo> findById(Integer id);
}