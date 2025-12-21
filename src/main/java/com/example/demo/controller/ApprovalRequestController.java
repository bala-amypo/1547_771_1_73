package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService approvalRequestService;

    public ApprovalRequestController(ApprovalRequestService approvalRequestService) {
        this.approvalRequestService = approvalRequestService;
    }

    @PostMapping
    public ResponseEntity<ApprovalRequest> createRequest(
            @RequestBody ApprovalRequest request) {
        return ResponseEntity.status(201)
                .body(approvalRequestService.createRequest(request));
    }

    @GetMapping
    public ResponseEntity<List<ApprovalRequest>> getRequests(
            @RequestParam(required = false) Long requesterId) {

        if (requesterId != null) {
            return ResponseEntity.ok(
                    approvalRequestService.getRequestsByRequester(requesterId));
        }
        return ResponseEntity.ok(approvalRequestService.getAllRequests());
    }
}
