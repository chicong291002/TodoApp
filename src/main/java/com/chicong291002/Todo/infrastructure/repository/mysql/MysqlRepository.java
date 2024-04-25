package com.chicong291002.Todo.infrastructure.repository.mysql;

import com.chicong291002.Todo.domain.entitiy.Todo;
import com.chicong291002.Todo.domain.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

public class MysqlRepository implements TodoRepository {
    private final SpringDataMysqlRepository mysqlRepository;

    public MysqlRepository(SpringDataMysqlRepository mysqlRepository) {
        this.mysqlRepository = mysqlRepository;
    }
    @Override
    public Optional<Todo> findByUserId(Integer userId) {
        return mysqlRepository.findById(userId);
    }

    @Override
    public List<Todo> findAllByUserId(Integer userId) {
        return mysqlRepository.findAllById(List.of(userId));
    }

    @Override
    public Todo save(Todo todo) {
        return mysqlRepository.save(todo);
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        return mysqlRepository.findById(id);
    }
}
