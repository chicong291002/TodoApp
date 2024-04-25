package com.chicong291002.Todo.infrastructure.repository.mongodb;

import com.chicong291002.Todo.domain.entitiy.Todo;
import com.chicong291002.Todo.domain.repository.TodoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class MongoDbRepository implements TodoRepository {

    private final SpringDataMongoRepository mongoRepository;

    public MongoDbRepository(SpringDataMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Optional<Todo> findByUserId(Integer userId) {
        return mongoRepository.findById(userId);
    }

    @Override
    public List<Todo> findAllByUserId(Integer userId) {
        return mongoRepository.findAllById(Collections.singleton(userId));
    }

    @Override
    public Todo save(Todo todo) {
        return mongoRepository.save(todo);
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        return mongoRepository.findById(id);
    }
}
