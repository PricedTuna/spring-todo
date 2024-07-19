package com.example.todo.controller;

import com.example.todo.DTO.CreateTaskDTO;
import com.example.todo.DTO.StatusTaskUpdateDTO;
import com.example.todo.DTO.UpdateTaskDTO;
import com.example.todo.entities.Task;
import com.example.todo.mapper.CreateTaskMapper;
import com.example.todo.service.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/tasks") // Controller path
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/{taskId}")
    public Optional<Task> getById(@PathVariable("taskId") Long taskId){
        return taskService.getById(taskId);
    }

    @PostMapping
    public Task create(@RequestBody CreateTaskDTO createTaskDTO){
        Task task = CreateTaskMapper.dtoToEntity(createTaskDTO);
        return taskService.create(task);
    }

    @PutMapping
    public Task update(@RequestBody UpdateTaskDTO updateTaskDTO){
        return taskService.update(updateTaskDTO);
    }

    @DeleteMapping("/{taskId}")
    public void delete(@PathVariable("taskId") Long taskId){
        taskService.delete(taskId);
    }

    @PatchMapping
    public Task updateStatus(@RequestBody StatusTaskUpdateDTO statusTaskUpdateDTO){
        return taskService.updateStatus(statusTaskUpdateDTO);
    }

}
