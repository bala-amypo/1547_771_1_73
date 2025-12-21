package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.ApprovalActionService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ApprovalAction;
import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository approvalActionRepository;
    private final ApprovalRequestRepository approvalRequestRepository;

    public ApprovalActionServiceImpl(
            ApprovalActionRepository approvalActionRepository,
            ApprovalRequestRepository approvalRequestRepository) {

        this.approvalActionRepository = approvalActionRepository;
        this.approvalRequestRepository = approvalRequestRepository;
    }

    @Override
    public ApprovalAction recordAction(ApprovalAction action) {

        ApprovalRequest request = approvalRequestRepository
                .findById(action.getRequestId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ApprovalRequest not found with id " + action.getRequestId()));

        if ("APPROVED".equals(action.getAction())) {
            request.setCurrentLevel(request.getCurrentLevel() + 1);
        } else if ("REJECTED".equals(action.getAction())) {
            request.setStatus("REJECTED");
        }

        approvalRequestRepository.save(request);
        return approvalActionRepository.save(action);
    }
}
