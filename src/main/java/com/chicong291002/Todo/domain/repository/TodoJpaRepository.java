package com.chicong291002.Todo.domain.repository;

import com.chicong291002.Todo.domain.entitiy.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {
}
