package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest req) {
        return service.createRequest(req);
    }

    @GetMapping
    public List<ApprovalRequest> getAll(
            @RequestParam(required = false) Long requesterId) {

        return requesterId == null
                ? service.getAllRequests()
                : service.getRequestsByRequester(requesterId);
    }
}
