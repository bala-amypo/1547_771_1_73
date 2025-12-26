package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
@Tag(name = "Workflow Step", description = "Operations related to workflow step configurations")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService stepService;

    public WorkflowStepConfigController(WorkflowStepConfigService stepService) {
        this.stepService = stepService;
    }

    @PostMapping("/")
    @Operation(summary = "Create a new workflow step")
    public ResponseEntity<WorkflowStepConfig> createStep(@RequestBody WorkflowStepConfig step) {
        return ResponseEntity.ok(stepService.createStep(step));
    }

    @GetMapping("/template/{templateId}")
    @Operation(summary = "List ordered steps for a specific template")
    public ResponseEntity<List<WorkflowStepConfig>> getStepsForTemplate(@PathVariable Long templateId) {
        return ResponseEntity.ok(stepService.getStepsForTemplate(templateId));
    }
}