package com.example.SimpleTaskManagementSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Task {

    @Id
    @Column(name = "task_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @Column(name = "task_name",length = 50)
    private String name;

    @Column(name = "description",length = 50)
    private String description;

    @Column(name = "assigned_by",length = 20)
    private String assignedBy;

    @Column(name = "assigned_for",length = 20)
    private String assignedFor;

    @Column(name = "assign_date",length = 20)
    private LocalDate assignDate;

    @Column(name = "deadline",length = 20)
    private LocalDate deadline;

    @Column(name = "status",length = 20)
    private String status;

}
