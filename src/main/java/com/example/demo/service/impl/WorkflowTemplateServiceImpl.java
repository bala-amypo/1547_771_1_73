package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    @Autowired
    private WorkflowTemplateRepository workflowTemplateRepository;

    @Override
    public WorkflowTemplate createWorkflowTemplate(WorkflowTemplate workflowTemplate) {
        return workflowTemplateRepository.save(workflowTemplate);
    }

    @Override
    public List<WorkflowTemplate> getWorkflowTemplate() {
        return workflowTemplateRepository.findAll();
    }

    @Override
    public WorkflowTemplate getById(long id) {
        return workflowTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkflowTemplate not found with id " + id));
    }

    @Override
    public WorkflowTemplate updateWorkflowTemplate(long id, WorkflowTemplate workflowTemplate) {
        WorkflowTemplate existing = workflowTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkflowTemplate not found with id " + id));

        existing.setTemplateName(workflowTemplate.getTemplateName());
        existing.setDescription(workflowTemplate.getDescription());
        existing.setTotalLevels(workflowTemplate.getTotalLevels());
        existing.setActive(workflowTemplate.isActive());

        return workflowTemplateRepository.save(existing);
    }
}
