// package com.example.demo.service.impl;

// import com.example.demo.model.WorkflowTemplate;
// import com.example.demo.repository.WorkflowTemplateRepository;
// import com.example.demo.service.WorkflowTemplateService;
// import com.example.demo.exception.ResourceNotFoundException;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

//     private final WorkflowTemplateRepository repository;

//     public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public WorkflowTemplate createTemplate(WorkflowTemplate template) {
//         return repository.save(template);
//     }

//     @Override
//     public Optional<WorkflowTemplate> getTemplateById(Long id) {
//         return repository.findById(id);
//     }

//     @Override
//     public List<WorkflowTemplate> getAllTemplates() {
//         return repository.findAll();
//     }

//     @Override
//     public WorkflowTemplate activateTemplate(Long id, boolean active) {
//         WorkflowTemplate template = repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Template not found"));
//         template.setActive(active);
//         return repository.save(template);
//     }

//     // 🔥 REQUIRED FOR TESTS
//     @Override
//     public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate updated) {
//         WorkflowTemplate existing = repository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Template not found"));

//         existing.setTemplateName(updated.getTemplateName());
//         existing.setDescription(updated.getDescription());
//         existing.setTotalLevels(updated.getTotalLevels());
//         existing.setActive(updated.getActive());

//         return repository.save(existing);
//     }
// }




package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    @Autowired
    private WorkflowTemplateRepository repo;

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return repo.save(template);
    }

    @Override
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return repo.findById(id);
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        template.setId(id);
        return repo.save(template);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate t = repo.findById(id).orElseThrow();
        t.setActive(active);
        return repo.save(t);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return repo.findAll();
    }
}
