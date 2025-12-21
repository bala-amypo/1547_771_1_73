package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.ApprovalRequestService;
import com.example.demo.model.ApprovalRequest;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService approvalRequestService;

    public ApprovalRequestController(ApprovalRequestService approvalRequestService) {
        this.approvalRequestService = approvalRequestService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<ApprovalRequest> createRequest(
            @RequestBody ApprovalRequest request) {

        ApprovalRequest created =
                approvalRequestService.createRequest(request);

        return ResponseEntity.status(201).body(created);
    }

    // GET / OR GET /?requesterId=
    @GetMapping
    public ResponseEntity<List<ApprovalRequest>> getRequests(
            @RequestParam(required = false) Long requesterId) {

        if (requesterId != null) {
            return ResponseEntity.ok(
                    approvalRequestService.getRequestsByRequester(requesterId));
        }

        return ResponseEntity.ok(
                approvalRequestService.getAllRequests());
    }
}
