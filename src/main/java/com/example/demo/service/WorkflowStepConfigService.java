package com.example.demo.Service;

import java.util.List;
import com.example.demo.model.WorkflowStepConfig;

public interface WorkflowStepConfigService {

    WorkflowStepConfig createStep(WorkflowStepConfig workflowStepConfig);

    List<WorkflowStepConfig> getStepsForTemplate(Long templateId);
}
