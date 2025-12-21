package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;

@RestController
@RequestMapping("/api/workflow-templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return service.getWorkflowTemplate();
    }

    @PostMapping
    public ResponseEntity<WorkflowTemplate> create(
            @RequestBody WorkflowTemplate template) {
        return ResponseEntity.status(201)
                .body(service.createWorkflowTemplate(template));
    }

    @GetMapping("/{id}")
    public WorkflowTemplate get(@PathVariable long id) {
        return service.getById(id);
    }
}
