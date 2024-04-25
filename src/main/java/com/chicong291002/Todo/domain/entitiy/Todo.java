package com.chicong291002.Todo.domain.entitiy;

import com.chicong291002.Todo.domain.dto.TodoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor // Thêm constructor không tham số
@AllArgsConstructor // Thêm constructor có tham số
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Integer todoId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private String status;

    public void addTodo(TodoDto todoDto) {
        this.userId = todoDto.getUserId();
        this.title = todoDto.getTitle();
        this.content = todoDto.getContent();
        this.status = todoDto.getStatus();
    }

    public void removeTodo() {
        this.userId = null;
        this.title = null;
        this.content = null;
        this.status = null;
    }

    public void updateTodo(TodoDto todoDto) {
        this.userId = todoDto.getUserId();
        this.title = todoDto.getTitle();
        this.content = todoDto.getContent();
        this.status = todoDto.getStatus();
    }
}