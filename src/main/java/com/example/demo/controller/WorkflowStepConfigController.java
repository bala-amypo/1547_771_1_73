package com.example.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;

@RestController
@RequestMapping("/api/workflow-step-config")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService service;

    public WorkflowStepConfigController(WorkflowStepConfigService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WorkflowStepConfig> create(
            @RequestBody WorkflowStepConfig config) {
        return ResponseEntity.status(201).body(service.createStep(config));
    }

    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<WorkflowStepConfig>> getByTemplate(
            @PathVariable Long templateId) {
        return ResponseEntity.ok(service.getStepsForTemplate(templateId));
    }
}
