package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;

@RestController
@RequestMapping("/workflowtemplate")
public class WorkflowTemplateController {

    @Autowired
    private WorkflowTemplateService workflowTemplateService;

    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return workflowTemplateService.getWorkflowTemplate();
    }

    @PostMapping
    public ResponseEntity<WorkflowTemplate> create(
            @RequestBody WorkflowTemplate workflowTemplate) {

        WorkflowTemplate created =
                workflowTemplateService.createWorkflowTemplate(workflowTemplate);

        return ResponseEntity.status(201).body(created);
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
