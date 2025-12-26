package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "workflow_templates")
@Data
public class WorkflowTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String templateName;

    private String description;

    @Column(nullable = false)
    private Integer totalLevels;

    private Boolean active = true;
}