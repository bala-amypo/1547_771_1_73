// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.WorkflowStepConfig;
// import com.example.demo.service.WorkflowStepConfigService;

// @RestController
// @RequestMapping("/workflowstepconfig")
// public class WorkflowStepConfigController {

//     private final WorkflowStepConfigService workflowStepConfigService;

//     public WorkflowStepConfigController(WorkflowStepConfigService workflowStepConfigService) {
//         this.workflowStepConfigService = workflowStepConfigService;
//     }

//     @GetMapping("/template/{templateId}")
//     public ResponseEntity<List<WorkflowStepConfig>> getByTemplate(
//             @PathVariable Long templateId) {

//         List<WorkflowStepConfig> steps =
//                 workflowStepConfigService.getStepsForTemplate(templateId);

//         return ResponseEntity.ok(steps);
//     }

//     @PostMapping
//     public ResponseEntity<WorkflowStepConfig> create(
//             @RequestBody WorkflowStepConfig workflowStepConfig) {

//         WorkflowStepConfig saved =
//                 workflowStepConfigService.createStep(workflowStepConfig);

//         return ResponseEntity.status(201).body(saved);
//     }
// }
