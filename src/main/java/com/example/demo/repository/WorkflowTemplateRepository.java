package com.example.demo.repository;

import com.example.demo.model.WorkflowTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkflowTemplateRepository extends JpaRepository<WorkflowTemplate, Long> {

    // ----------------------------------------------------
    // Used in TestNG: findByName
    // ----------------------------------------------------
    Optional<WorkflowTemplate> findByName(String name);
}
