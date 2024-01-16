package com.example.SimpleTaskManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskUpdateRequestDTO {

    private String name;
    private String status;
}
