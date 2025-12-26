package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    @Autowired
    private WorkflowTemplateRepository templateRepository;

    @Autowired
    private WorkflowStepConfigRepository stepConfigRepository;

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return templateRepository.save(template);
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        return templateRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("WorkflowTemplate not found with id: " + id));
    }

    @Override
    public WorkflowTemplate getTemplateByName(String name) {
        return templateRepository.findByName(name)
                .orElseThrow(() ->
                        new ResourceNotFoundException("WorkflowTemplate not found: " + name));
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }

    @Override
    public void deleteTemplate(Long id) {
        if (!templateRepository.existsById(id)) {
            throw new ResourceNotFoundException("WorkflowTemplate not found with id: " + id);
        }
        stepConfigRepository.deleteByWorkflowTemplateId(id);
        templateRepository.deleteById(id);
    }
}
