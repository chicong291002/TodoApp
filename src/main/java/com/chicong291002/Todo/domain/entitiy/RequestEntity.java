package com.chicong291002.Todo.domain.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEntity {
    private String operation;
    private String object;
    private Object body;
}
