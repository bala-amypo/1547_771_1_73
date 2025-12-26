package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalActionService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {
    private final ApprovalActionRepository actionRepository;
    private final ApprovalRequestRepository requestRepository;

    public ApprovalActionServiceImpl(ApprovalActionRepository actionRepository, 
                                     ApprovalRequestRepository requestRepository) {
        this.actionRepository = actionRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public ApprovalAction recordAction(ApprovalAction action) {
        ApprovalAction savedAction = actionRepository.save(action);
        
        // Rule: Update associated ApprovalRequest status/level
        ApprovalRequest request = requestRepository.findById(action.getRequestId())
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        
        if ("REJECTED".equals(action.getAction())) {
            request.setStatus("REJECTED");
        } else if ("APPROVED".equals(action.getAction())) {
            // Logic to increment level or mark as COMPLETED would go here
            request.setCurrentLevel(request.getCurrentLevel() + 1);
        }
        
        requestRepository.save(request);
        return savedAction;
    }
}