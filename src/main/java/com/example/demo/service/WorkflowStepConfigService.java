package com.example.demo.service;

import com.example.demo.model.WorkflowStepConfig;

import java.util.List;

public interface WorkflowStepConfigService {

    WorkflowStepConfig createStep(WorkflowStepConfig stepConfig);

    WorkflowStepConfig getStepById(Long id);

    List<WorkflowStepConfig> getStepsByTemplateId(Long templateId);

    WorkflowStepConfig updateStep(Long id, WorkflowStepConfig stepConfig);

    void deleteStep(Long id);

   
    WorkflowStepConfig getById(Long id);
    List<WorkflowStepConfig> getStepsByTemplate(Long templateId);


}
