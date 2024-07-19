package com.example.todo.DTO;

import com.example.todo.entities.Task;
import lombok.Data;

@Data
public class StatusTaskUpdateDTO {
    Long taskId;
    Task.Status newStatus;
}
