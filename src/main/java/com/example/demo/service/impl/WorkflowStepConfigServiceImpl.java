// package com.example.demo.service.impl;

// import com.example.demo.model.WorkflowStepConfig;
// import com.example.demo.repository.WorkflowStepConfigRepository;
// import com.example.demo.service.WorkflowStepConfigService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {
//     private final WorkflowStepConfigRepository stepRepository;

//     public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository stepRepository) {
//         this.stepRepository = stepRepository;
//     }

//     @Override
//     public WorkflowStepConfig createStep(WorkflowStepConfig step) {
//         return stepRepository.save(step);
//     }

//     @Override
//     public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
//         // Rule: Must return steps ordered by levelNumber
//         return stepRepository.findByTemplateIdOrderByLevelNumberAsc(templateId);
//     }
// }