package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.WorkflowStepConfig;

public interface WorkflowStepConfigRepository
        extends JpaRepository<WorkflowStepConfig, Long> {

    List<WorkflowStepConfig> findByTemplateId(Long templateId);
}
