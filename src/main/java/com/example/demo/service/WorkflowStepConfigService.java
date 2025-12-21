package com.example.demo.service;

import java.util.List;
import com.example.demo.model.WorkflowStepConfig;

public interface WorkflowStepConfigService {
    WorkflowStepConfig createStep(WorkflowStepConfig config);
    List<WorkflowStepConfig> getStepsForTemplate(Long templateId);
}
