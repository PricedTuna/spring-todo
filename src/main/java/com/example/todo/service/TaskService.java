package com.example.todo.service;

import com.example.todo.DTO.StatusTaskUpdateDTO;
import com.example.todo.DTO.UpdateTaskDTO;
import com.example.todo.entities.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired // DI for the repository
    TaskRepository taskRepository;

    // get all tasks
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    // get task by id
    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    // TODO: get task by status

    // create new task
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task update(UpdateTaskDTO updateTaskDTO){
        Long taskId = updateTaskDTO.getTaskId();
        String newTitle = updateTaskDTO.getTitle();
        String newDescription = updateTaskDTO.getDescription();

        Optional<Task> optionalTask = this.getById(taskId);

        if(optionalTask.isPresent()){ // Validate if the task exist
            Task task = optionalTask.get(); // get the task object

            task.setTitle(newTitle);
            task.setDescription(newDescription);

            return taskRepository.save(task); // save it and return the new task
        }
        throw new RuntimeException("Task not found");
    }

    // delete task
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateStatus(StatusTaskUpdateDTO statusTaskUpdateDTO){
        Long taskId = statusTaskUpdateDTO.getTaskId();
        Task.Status newStatus = statusTaskUpdateDTO.getNewStatus();

        Optional<Task> optionalTask = this.getById(taskId);

        if(optionalTask.isPresent()){ // Validate if the task exist
            Task task = optionalTask.get(); // get the task object
            task.setStatus(newStatus); // set the new status
            return taskRepository.save(task); // save it and return the new task
        }
        throw new RuntimeException("Task not found");

    }



}
