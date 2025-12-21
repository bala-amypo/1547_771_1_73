// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.WorkflowStepConfig;
// import com.example.demo.repository.WorkflowStepConfigRepository;
// import com.example.demo.service.WorkflowStepConfigService;

// @Service
// public class WorkflowStepConfigImpl implements WorkflowStepConfigService {

//     @Autowired
//     private WorkflowStepConfigRepository workflowStepConfigRepository;

//     @Override
//     public WorkflowStepConfig createStep(WorkflowStepConfig workflowStepConfig) {
//         return workflowStepConfigRepository.save(workflowStepConfig);
//     }

//     @Override
//     public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
//         List<WorkflowStepConfig> steps =
//                 workflowStepConfigRepository.findByTemplateId(templateId);

//         if (steps.isEmpty()) {
//             throw new ResourceNotFoundException(
//                     "No workflow steps found for template ID: " + templateId
//             );
//         }

//         return steps;
//     }
// }
