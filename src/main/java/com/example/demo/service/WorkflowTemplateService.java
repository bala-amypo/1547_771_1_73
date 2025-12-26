package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;

import java.util.List;

public interface WorkflowTemplateService {

    WorkflowTemplate createTemplate(WorkflowTemplate template);

    WorkflowTemplate getTemplateById(Long id);

    WorkflowTemplate getTemplateByName(String name);

    List<WorkflowTemplate> getAllTemplates();

    void deleteTemplate(Long id);
}
