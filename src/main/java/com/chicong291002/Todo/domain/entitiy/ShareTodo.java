package com.chicong291002.Todo.domain.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sharetodo")
@Entity
@IdClass(ShareTodo.ShareTodoId.class)
public class ShareTodo {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Id
    @Column(name = "todo_id")
    private Integer todoId;
    @MapsId("todoId")
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static class ShareTodoId implements Serializable {

        private Integer todoId;
        private Integer userId;

        public ShareTodoId(Integer todoId, Integer userId) {
            this.todoId = todoId;
            this.userId = userId;
        }

        public ShareTodoId() {
        }

        public Integer getTodoId() {
            return todoId;
        }

        public void setTodoId(Integer todoId) {
            this.todoId = todoId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }
    }
}
