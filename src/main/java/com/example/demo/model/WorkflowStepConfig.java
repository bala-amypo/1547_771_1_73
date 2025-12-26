package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "workflow_step_configs")
@Data
public class WorkflowStepConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long templateId; // Plain Long as per rules
    private Integer levelNumber;
    private String approverRole;
    private Boolean isFinalStep;
    private String instructions;
}