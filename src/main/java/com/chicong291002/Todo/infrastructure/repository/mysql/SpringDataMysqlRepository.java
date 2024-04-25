package com.chicong291002.Todo.infrastructure.repository.mysql;

import com.chicong291002.Todo.domain.dto.TodoDto;
import com.chicong291002.Todo.domain.entitiy.Todo;
import com.chicong291002.Todo.infrastructure.repository.mongodb.SpringDataMongoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMysqlRepository extends JpaRepository<Todo, Integer> {
}
