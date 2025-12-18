package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WorkflowStepConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long templateId;
    private int levelNumber;
    private String approverRole;
    private boolean finalStep;
    private String instructions;

    public WorkflowStepConfig() {
    }

    public WorkflowStepConfig(long templateId, int levelNumber, String approverRole,
                              boolean finalStep, String instructions) {
        this.templateId = templateId;
        this.levelNumber = levelNumber;
        this.approverRole = approverRole;
        this.finalStep = finalStep;
        this.instructions = instructions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getApproverRole() {
        return approverRole;
    }

    public void setApproverRole(String approverRole) {
        this.approverRole = approverRole;
    }

    public boolean isFinalStep() {
        return finalStep;
    }

    public void setFinalStep(boolean finalStep) {
        this.finalStep = finalStep;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
