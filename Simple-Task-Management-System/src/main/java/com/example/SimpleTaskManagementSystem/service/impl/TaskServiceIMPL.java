package com.example.SimpleTaskManagementSystem.service.impl;

import com.example.SimpleTaskManagementSystem.dto.TaskDTO;
import com.example.SimpleTaskManagementSystem.dto.request.TaskSaveRequestDTO;
import com.example.SimpleTaskManagementSystem.dto.request.TaskUpdateRequestDTO;
import com.example.SimpleTaskManagementSystem.entity.Task;
import com.example.SimpleTaskManagementSystem.repository.TaskRepo;
import com.example.SimpleTaskManagementSystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceIMPL implements TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public String addTask(TaskSaveRequestDTO taskSaveRequestDTO) {
        Task task = new Task(
                1,
                taskSaveRequestDTO.getName(),
                taskSaveRequestDTO.getDescription(),
                taskSaveRequestDTO.getAssignedBy(),
                taskSaveRequestDTO.getAssignedFor(),
                taskSaveRequestDTO.getAssignDate(),
                taskSaveRequestDTO.getDeadline(),
                taskSaveRequestDTO.getStatus()
        );
        if(!taskRepo.existsById(task.getTaskId())){
            taskRepo.save(task);
            return task.getName() + " Saved";
        }else{

            return "This customer already exists.";

        }
    }

    @Override
    public String updateTaskByQuery(TaskUpdateRequestDTO taskUpdateRequestDTO, int id) {
        if (taskRepo.existsById(id)){
            taskRepo.updateTaskByQuery(taskUpdateRequestDTO.getName(),taskUpdateRequestDTO.getStatus(),id);
            return "update successfully by id : " +id;
        }else{
            return "this task not in database";
        }

    }

    @Override
    public boolean deleteTask(int id) throws ChangeSetPersister.NotFoundException {
        if(taskRepo.existsById(id)){
            taskRepo.deleteById(id);
        }else{
            throw new ChangeSetPersister.NotFoundException();
        }
        return false;
    }
}
