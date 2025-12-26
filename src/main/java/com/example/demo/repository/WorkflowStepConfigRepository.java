package com.example.demo.repository;

import com.example.demo.model.WorkflowStepConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WorkflowStepConfigRepository extends JpaRepository<WorkflowStepConfig, Long> {
    // Required by Section 4 and Section 7
    List<WorkflowStepConfig> findByTemplateIdOrderByLevelNumberAsc(Long templateId);
}