package com.example.demo.service;

import java.util.List;
import com.example.demo.model.WorkflowStepConfig;

public interface WorkflowStepConfigService {

    WorkflowStepConfig createWorkflowStepConfig(WorkflowStepConfig workflowStepConfig);

    List<WorkflowStepConfig> getWorkflowStepConfigs();
}