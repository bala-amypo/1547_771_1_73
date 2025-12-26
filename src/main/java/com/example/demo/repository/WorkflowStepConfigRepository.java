package com.example.demo.repository;

import com.example.demo.model.WorkflowStepConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkflowStepConfigRepository extends JpaRepository<WorkflowStepConfig, Long> {

    // ----------------------------------------------------
    // Used in TestNG: findByWorkflowTemplateId
    // ----------------------------------------------------
    List<WorkflowStepConfig> findByWorkflowTemplateId(Long workflowTemplateId);

    // ----------------------------------------------------
    // Used when deleting template
    // ----------------------------------------------------
    void deleteByWorkflowTemplateId(Long workflowTemplateId);
}
