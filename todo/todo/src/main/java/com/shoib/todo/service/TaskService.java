package com.shoib.todo.service;

import com.shoib.todo.model.Task;
import com.shoib.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Task createTask( Task task){
        return  taskRepository.save(task);
    }
    public  Task getTaskById(Long id){
        return  taskRepository.getById(id);
    }
    public List<Task> getAllTask(){
        return  taskRepository.findAll();
    }
    public Task updateTask(Long id, Task updatedTask){
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setTask(updatedTask.getTask());
            task.setStartDate(updatedTask.getStartDate());
            task.setEndDate(updatedTask.getEndDate());
            task.setRepeating(updatedTask.isRepeating());
            return taskRepository.save(task);
        }).orElse(null);
    }
    public boolean deleteTask ( Long id){
        if( taskRepository.existsById(id) ){
            taskRepository.deleteById(id);
            return  true;
        }
        return false;
    }
}
