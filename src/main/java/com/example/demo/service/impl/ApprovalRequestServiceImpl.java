package com.example.demo.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Service.ApprovalRequestService;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.repository.WorkflowStepConfigRepository;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository approvalRequestRepository;

    public ApprovalRequestServiceImpl(
            ApprovalRequestRepository approvalRequestRepository,
            WorkflowStepConfigRepository workflowStepConfigRepository,
            WorkflowTemplateRepository workflowTemplateRepository,
            ApprovalActionRepository approvalActionRepository) {

        this.approvalRequestRepository = approvalRequestRepository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest request) {
        return approvalRequestRepository.save(request);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return approvalRequestRepository.findAll();
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        List<ApprovalRequest> requests =
                approvalRequestRepository.findByRequesterId(requesterId);

        if (requests.isEmpty()) {
            throw new ResourceNotFoundException(
                "No requests found for requesterId: " + requesterId
            );
        }
        return requests;
    }
}
