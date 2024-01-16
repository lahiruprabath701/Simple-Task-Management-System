package com.example.SimpleTaskManagementSystem.repository;

import com.example.SimpleTaskManagementSystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@EnableJpaRepositories
@Transactional

public interface TaskRepo extends JpaRepository<Task,Integer> {

    @Modifying
    @Query(value = "update Task set name=?1,status=?2 where taskId=?3")
    void updateTaskByQuery(String name, String status, int id);
}
