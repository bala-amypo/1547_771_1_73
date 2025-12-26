package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;

import java.util.List;

public interface WorkflowTemplateService {

    WorkflowTemplate createTemplate(WorkflowTemplate template);

    WorkflowTemplate getTemplateById(Long id);

    WorkflowTemplate getTemplateByName(String name);

    List<WorkflowTemplate> getAllTemplates();

    void deleteTemplate(Long id);
    
    WorkflowTemplate getById(Long id);
    WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template);
    WorkflowTemplate activateTemplate(Long id, boolean active);
}

}
