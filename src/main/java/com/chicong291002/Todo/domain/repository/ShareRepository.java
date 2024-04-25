package com.chicong291002.Todo.domain.repository;

import com.chicong291002.Todo.domain.entitiy.ShareTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShareRepository extends JpaRepository<ShareTodo, Integer> {
    @Modifying
    @Query(value = "DELETE FROM `sharetodo` WHERE todo_id=:todoId", nativeQuery = true)
    void deleteByTodoId(@Param("todoId")Integer todoId);

    boolean existsByUserIdAndTodoId(Integer userId, Integer todoId);
}
