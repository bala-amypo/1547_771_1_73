package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo1.model.WorkflowStepConfig;

public interface WorkflowStepConfigRepository
        extends JpaRepository<WorkflowStepConfig, Long> {
}
