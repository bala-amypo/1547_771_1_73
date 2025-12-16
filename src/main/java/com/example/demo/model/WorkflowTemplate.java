package com.example.demo.model;

public class WorkflowTemplate {
    private long id;
    private String templateName;
    private String description;
    private int totalLevels;
    private boolean active;

    public WorkflowTemplate(){

    }

    public WorkflowTemplate(long id, String templateName, String description, int totalLevels, boolean active) {
        this.id = id;
        this.templateName = templateName;
        this.description = description;
        this.totalLevels = totalLevels;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalLevels() {
        return totalLevels;
    }

    public void setTotalLevels(int totalLevels) {
        this.totalLevels = totalLevels;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
