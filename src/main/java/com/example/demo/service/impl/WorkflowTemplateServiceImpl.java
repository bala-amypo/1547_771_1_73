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
//     private final WorkflowTemplateRepository templateRepository;

//     public WorkflowTemplateServiceImpl(WorkflowTemplateRepository templateRepository) {
//         this.templateRepository = templateRepository;
//     }

//     @Override
//     public WorkflowTemplate createTemplate(WorkflowTemplate t) {
//         if (t.getActive() == null) t.setActive(true);
//         return templateRepository.save(t);
//     }

//     @Override
//     public Optional<WorkflowTemplate> getTemplateById(Long id) {
//         return templateRepository.findById(id);
//     }

//     @Override
//     public List<WorkflowTemplate> getAllTemplates() {
//         return templateRepository.findAll();
//     }

//     @Override
//     public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
//         WorkflowTemplate existing = templateRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Template not found"));
//         existing.setTemplateName(t.getTemplateName());
//         existing.setDescription(t.getDescription());
//         existing.setTotalLevels(t.getTotalLevels());
//         return templateRepository.save(existing);
//     }

//     @Override
//     public WorkflowTemplate activateTemplate(Long id, boolean active) {
//         WorkflowTemplate existing = templateRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Template not found"));
//         existing.setActive(active);
//         return templateRepository.save(existing);
//     }
// }