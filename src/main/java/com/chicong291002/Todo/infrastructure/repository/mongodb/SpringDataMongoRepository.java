package com.chicong291002.Todo.infrastructure.repository.mongodb;

import com.chicong291002.Todo.domain.dto.TodoDto;
import com.chicong291002.Todo.domain.entitiy.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoRepository extends MongoRepository<Todo, Integer> {
}
