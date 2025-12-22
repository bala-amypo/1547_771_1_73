package com.example.demo.service.impl;

import com.example.demo.entity.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository approvalRequestRepository;
    private final WorkflowStepConfigRepository workflowStepConfigRepository;
    private final WorkflowTemplateRepository workflowTemplateRepository;
    private final ApprovalActionRepository approvalActionRepository;

    public ApprovalRequestServiceImpl(
            ApprovalRequestRepository approvalRequestRepository,
            WorkflowStepConfigRepository workflowStepConfigRepository,
            WorkflowTemplateRepository workflowTemplateRepository,
            ApprovalActionRepository approvalActionRepository) {

        this.approvalRequestRepository = approvalRequestRepository;
        this.workflowStepConfigRepository = workflowStepConfigRepository;
        this.workflowTemplateRepository = workflowTemplateRepository;
        this.approvalActionRepository = approvalActionRepository;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest request) {
        List<ApprovalRequest> allRequests = approvalRequestRepository.findAll();
        request.setId((long) (allRequests.size() + 1));
        allRequests.add(request);
        return request;
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        List<ApprovalRequest> allRequests = approvalRequestRepository.findAll();
        List<ApprovalRequest> result = new ArrayList<>();
        for (ApprovalRequest r : allRequests) {
            if (requesterId.equals(r.getRequesterId())) result.add(r);
        }
        return result;
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return new ArrayList<>(approvalRequestRepository.findAll());
    }
}
