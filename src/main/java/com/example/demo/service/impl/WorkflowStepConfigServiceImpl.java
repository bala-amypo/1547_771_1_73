package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.service.WorkflowStepConfigService;
import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class WorkflowStepConfigServiceImpl
        implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository repo;

    public WorkflowStepConfigServiceImpl(
            WorkflowStepConfigRepository repo) {
        this.repo = repo;
    }

    @Override
    public WorkflowStepConfig createStep(WorkflowStepConfig config) {
        return repo.save(config);
    }

    @Override
    public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
        List<WorkflowStepConfig> steps =
                repo.findByTemplateId(templateId);
        if (steps.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No steps for template " + templateId);
        }
        return steps;
    }
}
