package com.example.todo.mapper;

import com.example.todo.DTO.CreateTaskDTO;
import com.example.todo.entities.Task;

public class CreateTaskMapper {

    public static Task dtoToEntity(CreateTaskDTO createTaskDTO) {
        Task task = new Task();

        task.setTitle(createTaskDTO.getTitle());
        task.setDescription(createTaskDTO.getDescription());
        task.setStatus(Task.Status.PENDING);

        return task;
    }

    public static CreateTaskDTO entityToDto(Task task) {
        CreateTaskDTO createTaskDTO = new CreateTaskDTO();

        createTaskDTO.setTitle(task.getTitle());
        createTaskDTO.setDescription(task.getDescription());

        return createTaskDTO;
    }

}
