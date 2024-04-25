package com.chicong291002.Todo.domain.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoDto {
    private Integer todoId;
    private Integer userId;
    private String title;
    private String content;
    private String status;
}
