package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approval-requests")
public class ApprovalRequestController {

    @Autowired
    private ApprovalRequestService approvalRequestService;

    // ----------------------------------------------------
    // Create approval request
    // ----------------------------------------------------
    @PostMapping
    public ResponseEntity<ApprovalRequest> createRequest(
            @RequestBody ApprovalRequest request) {

        ApprovalRequest saved = approvalRequestService.createRequest(request);
        return ResponseEntity.ok(saved);
    }

    // ----------------------------------------------------
    // Get approval request by ID
    // ----------------------------------------------------
   @GetMapping("/{id}")
    public ResponseEntity<ApprovalRequest> getById(@PathVariable Long id) {
    ApprovalRequest request = approvalRequestService.getById(id);
    return ResponseEntity.ok(request);
}


    // ----------------------------------------------------
    // Get all approval requests
    // ----------------------------------------------------
    @GetMapping
    public ResponseEntity<List<ApprovalRequest>> getAllRequests() {
        return ResponseEntity.ok(approvalRequestService.getAllRequests());
    }

    // ----------------------------------------------------
    // Get requests by requester ID
    // ----------------------------------------------------
    @GetMapping("/requester/{requesterId}")
    public ResponseEntity<List<ApprovalRequest>> getByRequester(
            @PathVariable Long requesterId) {

        return ResponseEntity.ok(
                approvalRequestService.getRequestsByRequester(requesterId)
        );
    }

    // ----------------------------------------------------
    // Update request status
    // ----------------------------------------------------
    @PutMapping("/{id}/status")
    public ResponseEntity<ApprovalRequest> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        ApprovalRequest updated =
                approvalRequestService.updateRequestStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    // ----------------------------------------------------
    // Delete approval request
    // ----------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        approvalRequestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
