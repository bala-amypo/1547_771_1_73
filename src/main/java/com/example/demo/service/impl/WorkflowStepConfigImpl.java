package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository repository;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowStepConfig createStep(WorkflowStepConfig workflowStepConfig) {
        return repository.save(workflowStepConfig);
    }

    @Override
    public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
        List<WorkflowStepConfig> steps = repository.findByTemplateId(templateId);

        if (steps.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No steps found for templateId " + templateId);
        }
        return steps;
    }
}
