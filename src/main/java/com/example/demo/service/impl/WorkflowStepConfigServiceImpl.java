// package com.example.demo.service.impl;

// import com.example.demo.model.WorkflowStepConfig;
// import com.example.demo.repository.WorkflowStepConfigRepository;
// import com.example.demo.service.WorkflowStepConfigService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

//     private final WorkflowStepConfigRepository repository;

//     public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repository) {
//         this.repository = repository;
//     }

//     public WorkflowStepConfig createStep(WorkflowStepConfig step) {
//         return repository.save(step);
//     }

//     public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
//         return repository.findByTemplateIdOrderByLevelNumberAsc(templateId);
//     }
// }



package com.example.demo.service;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl
        implements WorkflowStepConfigService {

    @Autowired
    private WorkflowStepConfigRepository repo;

    @Override
    public WorkflowStepConfig save(WorkflowStepConfig step) {
        return repo.save(step);
    }

    @Override
    public List<WorkflowStepConfig> findByTemplate(Long templateId) {
        return repo.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}
