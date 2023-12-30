package com.shoib.todo.controller;

import com.shoib.todo.model.Task;
import com.shoib.todo.service.TaskService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("create")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        try {
            Task createdTask = taskService.createTask(task);
            return new ResponseEntity<>(createdTask, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id ){
        try {
            Task task = taskService.getTaskById(id);
            if(task !=null){
                return new ResponseEntity<>(task,HttpStatus.OK);
            }else{
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getall")
    public ResponseEntity<List<Task>> gettasks(){
        try {
            List<Task> allTasks = taskService.getAllTask();
            return new ResponseEntity<>(allTasks, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }
    }

}
