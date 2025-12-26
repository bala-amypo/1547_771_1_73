package com.example.demo.service.impl;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.*;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {
    private final ApprovalRequestRepository requestRepository;
    private final WorkflowStepConfigRepository stepRepository;
    private final WorkflowTemplateRepository templateRepository;
    private final ApprovalActionRepository actionRepository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository requestRepository, 
                                      WorkflowStepConfigRepository stepRepository,
                                      WorkflowTemplateRepository templateRepository,
                                      ApprovalActionRepository actionRepository) {
        this.requestRepository = requestRepository;
        this.stepRepository = stepRepository;
        this.templateRepository = templateRepository;
        this.actionRepository = actionRepository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest req) {
        // Rule: Sets default status "PENDING" and currentLevel (usually 1)
        req.setStatus("PENDING");
        if (req.getCurrentLevel() == null) req.setCurrentLevel(1);
        return requestRepository.save(req);
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long userId) {
        return requestRepository.findByRequesterId(userId);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return requestRepository.findAll();
    }
}