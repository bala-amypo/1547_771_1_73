package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflow-step-configs")
public class WorkflowStepConfigController {

    @Autowired
    private WorkflowStepConfigService workflowStepConfigService;

    // ----------------------------------------------------
    // Create step configuration
    // ----------------------------------------------------
    @PostMapping
    public ResponseEntity<WorkflowStepConfig> createStep(
            @RequestBody WorkflowStepConfig stepConfig) {

        WorkflowStepConfig saved =
                workflowStepConfigService.createStep(stepConfig);
        return ResponseEntity.ok(saved);
    }

    // ----------------------------------------------------
    // Get step config by ID
    // ----------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<WorkflowStepConfig> getById(@PathVariable Long id) {
        return workflowStepConfigService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ----------------------------------------------------
    // Get steps by template ID (ordered)
    // ----------------------------------------------------
    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<WorkflowStepConfig>> getByTemplate(
            @PathVariable Long templateId) {

        return ResponseEntity.ok(
                workflowStepConfigService.getStepsByTemplate(templateId)
        );
    }

    // ----------------------------------------------------
    // Update step configuration
    // ----------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<WorkflowStepConfig> updateStep(
            @PathVariable Long id,
            @RequestBody WorkflowStepConfig stepConfig) {

        WorkflowStepConfig updated =
                workflowStepConfigService.updateStep(id, stepConfig);
        return ResponseEntity.ok(updated);
    }

    // ----------------------------------------------------
    // Delete step configuration
    // ----------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStep(@PathVariable Long id) {
        workflowStepConfigService.deleteStep(id);
        return ResponseEntity.noContent().build();
    }
}
