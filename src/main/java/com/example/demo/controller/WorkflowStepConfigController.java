package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;

@RestController
@RequestMapping("/workflowstepconfig")
public class WorkflowStepConfigController {

    @Autowired
    private WorkflowStepConfigService workflowStepConfigService;

    @GetMapping
    public List<WorkflowStepConfig> getAll() {
        return workflowStepConfigService.getWorkflowStepConfigs();
    }

    @PostMapping
    public ResponseEntity<WorkflowStepConfig> create(
            @RequestBody WorkflowStepConfig workflowStepConfig) {

        WorkflowStepConfig saved =
                workflowStepConfigService.createWorkflowStepConfig(workflowStepConfig);

        return ResponseEntity.status(201).body(saved);
    }
}
