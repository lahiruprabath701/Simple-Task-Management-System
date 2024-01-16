package com.example.SimpleTaskManagementSystem.controller;

import com.example.SimpleTaskManagementSystem.dto.TaskDTO;

import com.example.SimpleTaskManagementSystem.dto.request.TaskSaveRequestDTO;
import com.example.SimpleTaskManagementSystem.dto.request.TaskUpdateRequestDTO;
import com.example.SimpleTaskManagementSystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/task")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(path = "/save")
    public String saveTask(@RequestBody TaskSaveRequestDTO taskSaveRequestDTO){
        String id = taskService.addTask(taskSaveRequestDTO);
        return id;
    }

    @PutMapping(path = "/update-task/{id}")
    public String updateTaskByQuery(
            @RequestBody TaskUpdateRequestDTO taskUpdateRequestDTO,
            @PathVariable(value = "id") int id){
        String updated = taskService.updateTaskByQuery(taskUpdateRequestDTO,id);
        return updated;
    }

    @DeleteMapping(path = "/delete-task/{id}")
    public String deleteTask(@PathVariable(value = "id")int id) throws ChangeSetPersister.NotFoundException {

        boolean deleteTask = taskService.deleteTask(id);
        return "deleted";
    }

}
