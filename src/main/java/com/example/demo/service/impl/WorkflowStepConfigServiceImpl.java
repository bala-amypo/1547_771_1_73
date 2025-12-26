package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    @Autowired
    private WorkflowStepConfigRepository stepConfigRepository;

    @Override
    public WorkflowStepConfig createStep(WorkflowStepConfig stepConfig) {
        return stepConfigRepository.save(stepConfig);
    }

    @Override
    public WorkflowStepConfig getStepById(Long id) {
        return stepConfigRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("WorkflowStepConfig not found with id: " + id));
    }

    @Override
    public List<WorkflowStepConfig> getStepsByTemplateId(Long templateId) {
        return stepConfigRepository.findByWorkflowTemplateId(templateId);
    }

    @Override
    public WorkflowStepConfig updateStep(Long id, WorkflowStepConfig stepConfig) {
        WorkflowStepConfig existing = getStepById(id);

        existing.setStepOrder(stepConfig.getStepOrder());
        existing.setApproverRole(stepConfig.getApproverRole());
        existing.setAutoApprove(stepConfig.isAutoApprove());

        return stepConfigRepository.save(existing);
    }

    @Override
    public void deleteStep(Long id) {
        stepConfigRepository.deleteById(id);
    }
@Override
public WorkflowStepConfig getById(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Step not found"));
}

@Override
public List<WorkflowStepConfig> getStepsByTemplate(Long templateId) {
    return repository.findByWorkflowTemplateIdOrderByStepOrder(templateId);
}

    
}
