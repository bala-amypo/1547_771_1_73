package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflow-templates")
public class WorkflowTemplateController {

    @Autowired
    private WorkflowTemplateService workflowTemplateService;

    // ----------------------------------------------------
    // Create workflow template
    // ----------------------------------------------------
    @PostMapping
    public ResponseEntity<WorkflowTemplate> createTemplate(
            @RequestBody WorkflowTemplate template) {

        WorkflowTemplate saved =
                workflowTemplateService.createTemplate(template);
        return ResponseEntity.ok(saved);
    }

    // ----------------------------------------------------
    // Get template by ID
    // ----------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> getTemplateById(
            @PathVariable Long id) {

        return workflowTemplateService.getTemplateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ----------------------------------------------------
    // Get all templates
    // ----------------------------------------------------
    @GetMapping
    public ResponseEntity<List<WorkflowTemplate>> getAllTemplates() {
        return ResponseEntity.ok(
                workflowTemplateService.getAllTemplates()
        );
    }

    // ----------------------------------------------------
    // Update workflow template
    // ----------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> updateTemplate(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate template) {

        WorkflowTemplate updated =
                workflowTemplateService.updateTemplate(id, template);
        return ResponseEntity.ok(updated);
    }

    // ----------------------------------------------------
    // Activate / Deactivate template
    // ----------------------------------------------------
    @PutMapping("/{id}/active")
    public ResponseEntity<WorkflowTemplate> activateTemplate(
            @PathVariable Long id,
            @RequestParam boolean active) {

        WorkflowTemplate updated =
                workflowTemplateService.activateTemplate(id, active);
        return ResponseEntity.ok(updated);
    }

    // ----------------------------------------------------
    // Delete workflow template
    // ----------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTemplate(@PathVariable Long id) {
        workflowTemplateService.deleteTemplate(id);
        return ResponseEntity.noContent().build();
    }
}
