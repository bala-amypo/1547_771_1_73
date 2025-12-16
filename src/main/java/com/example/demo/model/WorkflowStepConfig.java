package com.example.demo.model;

public class WorkflowStepConfig {
    private long id;
    private long templateld;
    private int levelNumber;
    private String approverRole;
    private boolean isFinalStep;
    private String instructions;

    public  WorkflowStepConfig(){

    }

    public WorkflowStepConfig(long id, long templateld, int levelNumber, String approverRole, boolean isFinalStep,
            String instructions) {
        this.id = id;
        this.templateld = templateld;
        this.levelNumber = levelNumber;
        this.approverRole = approverRole;
        this.isFinalStep = isFinalStep;
        this.instructions = instructions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTemplateld() {
        return templateld;
    }

    public void setTemplateld(long templateld) {
        this.templateld = templateld;
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
        return isFinalStep;
    }

    public void setFinalStep(boolean isFinalStep) {
        this.isFinalStep = isFinalStep;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    
    
}
