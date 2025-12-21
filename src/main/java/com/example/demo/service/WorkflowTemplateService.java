package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.WorkflowTemplate;

public interface WorkflowTemplateService {
    WorkflowTemplate createWorkflowTemplate(WorkflowTemplate workflowTemplate);
    List<WorkflowTemplate> getWorkflowTemplate();
    WorkflowTemplate getById(long id);
    WorkflowTemplate updateWorkflowTemplate(long id, WorkflowTemplate workflowTemplate);
}