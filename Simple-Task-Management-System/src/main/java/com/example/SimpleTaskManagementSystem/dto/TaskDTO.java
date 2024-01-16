package com.example.SimpleTaskManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {

    private int taskId;
    private String name;
    private String description;
    private String assignedBy;
    private String assignedFor;
    private LocalDate assignDate;
    private LocalDate deadline;
    private String status;
}
