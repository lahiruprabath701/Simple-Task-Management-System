package com.example.SimpleTaskManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskSaveRequestDTO {
    private String name;
    private String description;
    private String assignedBy;
    private String assignedFor;
    private LocalDate assignDate;
    private LocalDate deadline;
    private String status;
}
