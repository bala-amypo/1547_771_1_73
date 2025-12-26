package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Approval Request", description = "Operations related to approval requests")
public class ApprovalRequestController {

    private final ApprovalRequestService requestService;

    public ApprovalRequestController(ApprovalRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/")
    @Operation(summary = "Create a new approval request")
    public ResponseEntity<ApprovalRequest> createRequest(@RequestBody ApprovalRequest request) {
        return ResponseEntity.ok(requestService.createRequest(request));
    }

    @GetMapping("/")
    @Operation(summary = "List all requests with optional requester filter")
    public ResponseEntity<List<ApprovalRequest>> listRequests(@RequestParam(required = false) Long requesterId) {
        if (requesterId != null) {
            return ResponseEntity.ok(requestService.getRequestsByRequester(requesterId));
        }
        return ResponseEntity.ok(requestService.getAllRequests());
    }
}