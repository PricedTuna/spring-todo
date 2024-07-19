package com.example.todo.DTO;

import lombok.Data;

@Data
public class UpdateTaskDTO {
    long taskId;
    private String title;
    private String description;
}
