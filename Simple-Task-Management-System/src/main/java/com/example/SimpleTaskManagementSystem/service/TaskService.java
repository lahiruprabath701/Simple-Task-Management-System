package com.example.SimpleTaskManagementSystem.service;


import com.example.SimpleTaskManagementSystem.dto.TaskDTO;
import com.example.SimpleTaskManagementSystem.dto.request.TaskSaveRequestDTO;
import com.example.SimpleTaskManagementSystem.dto.request.TaskUpdateRequestDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface TaskService {

    String addTask(TaskSaveRequestDTO taskSaveRequestDTO);

    String updateTaskByQuery(TaskUpdateRequestDTO taskUpdateRequestDTO, int id);

    boolean deleteTask(int id) throws ChangeSetPersister.NotFoundException;
}
