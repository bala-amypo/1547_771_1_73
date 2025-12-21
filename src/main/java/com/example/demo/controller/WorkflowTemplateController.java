package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;

@RestController
@RequestMapping("/api/workflow-templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService workflowTemplateService;

    public WorkflowTemplateController(WorkflowTemplateService workflowTemplateService) {
        this.workflowTemplateService = workflowTemplateService;
    }

    @PostMapping
    public ResponseEntity<WorkflowTemplate> create(
            @RequestBody WorkflowTemplate workflowTemplate) {

        return ResponseEntity.status(201)
                .body(workflowTemplateService.createWorkflowTemplate(workflowTemplate));
    }

    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return workflowTemplateService.getWorkflowTemplate();
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable long id) {
        return workflowTemplateService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable long id,
            @RequestBody WorkflowTemplate workflowTemplate) {

        workflowTemplateService.updateWorkflowTemplate(id, workflowTemplate);
        return ResponseEntity.ok("Update successful");
    }
}
